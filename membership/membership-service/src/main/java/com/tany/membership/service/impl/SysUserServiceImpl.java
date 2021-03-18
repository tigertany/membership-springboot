package com.tany.membership.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tany.membership.common.JWTUtil;
import com.tany.membership.common.MyPage;
import com.tany.membership.common.PagedResult;
import com.tany.membership.dao.SysUserMapper;
import com.tany.membership.dto.UserWithRolesDto;
import com.tany.membership.entity.SysUser;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysUserRoleService;
import com.tany.membership.service.ISysUserService;
import com.tany.membership.vo.UserWithRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysUserRoleService userRoleService;

    private List<String> staticParams = Arrays.asList("pageIndex","pageSize","sortColumn","sortMethod");

    @Override
    public IPage<UserWithRole> getUserList(IPage<UserWithRole> page, Wrapper<UserWithRole> queryWrapper) {

        return this.baseMapper.getUserList(page,queryWrapper);
    }

    @Override
    public List<UserWithRole> getUserList3(MyPage page,Wrapper<UserWithRole> queryWrapper) {
        return this.baseMapper.getUserList3(page,queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(long curUserId, UserWithRolesDto userWithRolesDto) {
        SysUser sysUser = userWithRolesDto.getSysUser();
        List<SysUserRole> sysUserRoleList = userWithRolesDto.getSysUserRoleList();

        sysUser.setCreateDate(new Date());
        sysUser.setCreater(curUserId);

        QueryWrapper<SysUserRole> sysUserRoleQueryWrapper = new QueryWrapper<>();
        sysUserRoleQueryWrapper.eq("user_id",sysUser.getId());

        userRoleService.remove(sysUserRoleQueryWrapper);
        userService.saveOrUpdate(sysUser);
        userRoleService.saveBatch(sysUserRoleList);

        return true;
    }

    @Override
    public boolean delete(long curUserId, Long[] ids) {
        List<SysUser> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++)
        {
            SysUser user = new SysUser();
            user.setId(ids[i]);
            user.setDeleted(true);
            user.setDeletedDate(new Date());
            list.add(user);
        }

        return userService.updateBatchById(list);
    }

    @Override
    public PagedResult query(long pageIndex, long pageSize, String sortColumn, String sortMethod, Map<String, Object> search) {
        MyPage page = new MyPage(pageIndex,pageSize,sortColumn,sortMethod);

        QueryWrapper<UserWithRole> wrapper = new QueryWrapper<>();
        wrapper.eq("deleted",0);

        //设置查询条件
        for (Map.Entry<String, Object> entry : search.entrySet()) {
            if (staticParams.contains(entry.getKey())) continue;
            wrapper.like(entry.getKey(),entry.getValue());
        }

        List<UserWithRole> list = userService.getUserList3(page,wrapper);

        QueryWrapper<SysUser> wrapperCount = new QueryWrapper<>();
        wrapperCount.eq("deleted",0);
        int pageCount = userService.count(wrapperCount);

        PagedResult pagedResult = new PagedResult();
        pagedResult.setTotalPage((pageCount + pageSize - 1)/pageSize);
        pagedResult.setTotalRecords(pageCount);
        pagedResult.setCurrentPage(pageIndex);
        pagedResult.setRows(list);
        return pagedResult;
    }

    @Override
    public UserWithRole queryById(long id) {
        LinkedHashMap<String,Object> search = new LinkedHashMap<>();
        search.put("id",id);
        PagedResult pagedResult = query(1, 1, "id", "asc", search);
        List<?> list = pagedResult.getRows();
        if (list.size()>0)
        {
            return (UserWithRole)list.get(0);
        }
        return null;
    }

    @Override
    public String login(String account, String pwd)  {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        wrapper.eq("account",account);

        SysUser user = userService.getOne(wrapper);

        if (user==null)
        {
            throw new RuntimeException("无此用户!");
        }
        if (!user.getPassword().equalsIgnoreCase(pwd))
        {
            throw new RuntimeException("密码错误!");
        }
        return JWTUtil.sign(user.getId());
    }

    @Override
    public boolean changePassword(String account, String oldPassword, String newPassword) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        wrapper.eq("account",account);

        SysUser user = userService.getOne(wrapper);

        if (user==null)
        {
            throw new RuntimeException("无此用户!");
        }
        if (!user.getPassword().equalsIgnoreCase(oldPassword))
        {
            throw new RuntimeException("密码错误!");
        }

        user.setPassword(newPassword);
        QueryWrapper<SysUser> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("password",newPassword);

        return userService.update(updateWrapper);
    }


}

package com.tany.membership.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tany.membership.common.MyPage;
import com.tany.membership.common.PagedResult;
import com.tany.membership.dto.UserWithRolesDto;
import com.tany.membership.entity.SysUser;
import com.tany.membership.vo.UserWithRole;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public interface ISysUserService extends IService<SysUser> {
    IPage<UserWithRole> getUserList(IPage<UserWithRole> page, Wrapper<UserWithRole> queryWrapper);
    List<UserWithRole> getUserList3(MyPage page, Wrapper<UserWithRole> queryWrapper);
    boolean save(long curUserId, UserWithRolesDto userWithRolesDto);
    boolean delete(long curUserId,Long[] ids);
    PagedResult query(long pageIndex, long pageSize, String sortColumn, String sortMethod, Map<String,Object> search);

    UserWithRole queryById(long id);

    String login(String account,String pwd);

    boolean changePassword(String account,String oldPassword,String newPassword);
}

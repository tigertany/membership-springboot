package com.tany.membership.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.MyPage;
import com.tany.membership.common.PagedResult;
import com.tany.membership.dto.SaveUserAndRoles;
import com.tany.membership.entity.SysUser;
import com.tany.membership.vo.UserWithRole;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;
import java.util.List;

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
    boolean save(String curUserId,SaveUserAndRoles saveUserAndRoles);
    boolean delete(String curUserId,Integer[] ids);
    PagedResult query(long pageIndex, long pageSize, String sortColumn, String sortMethod, LinkedHashMap<String,Object> search);

    UserWithRole queryById(long id);
}

package com.tany.membership.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tany.membership.entity.SysUser;
import com.tany.membership.vo.UserWithRole;

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
}

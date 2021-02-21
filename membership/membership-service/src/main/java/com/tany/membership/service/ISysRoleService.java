package com.tany.membership.service;

import com.tany.membership.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public interface ISysRoleService extends IService<SysRole> {
    List<SysRole> getRoleListByUser(long userId);

}

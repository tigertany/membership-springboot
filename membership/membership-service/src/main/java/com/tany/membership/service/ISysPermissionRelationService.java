package com.tany.membership.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tany.membership.entity.SysPermissionRelation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public interface ISysPermissionRelationService extends IService<SysPermissionRelation> {
    boolean saveRolePermission(Long userId,List<SysPermissionRelation> list);
}

package com.tany.membership.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tany.membership.dao.SysPermissionRelationMapper;
import com.tany.membership.entity.SysPermissionRelation;
import com.tany.membership.service.ISysPermissionRelationService;
import com.tany.membership.service.ISysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
@Service
public class SysPermissionRelationServiceImpl extends ServiceImpl<SysPermissionRelationMapper, SysPermissionRelation> implements ISysPermissionRelationService {
    @Transactional
    @Override
    public boolean saveRolePermission(Long userId,List<SysPermissionRelation> list) {
        QueryWrapper<SysPermissionRelation> wrapper = new QueryWrapper<>();

        wrapper.in("share_id",list.stream().map(s->s.getShareId()).toArray());

        ISysPermissionService.permissionCache.remove(userId);
        return this.remove(wrapper) && this.saveBatch(list);
    }
}

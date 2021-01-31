package com.tany.membership.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tany.membership.dao.SysPermissionMapper;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.vo.Menu;
import com.tany.membership.vo.PermissionWithChecked;
import org.springframework.stereotype.Service;

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
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Override
    public List<PermissionWithChecked> getPermissionByRole(Long roleId) {
        return this.baseMapper.selectPermissionByRole(roleId);
    }

    @Override
    public List<SysPermission> getPermissionByUser(Long userId) {

        if (!permissionCache.containsKey(userId))
        {
            permissionCache.put(userId,this.baseMapper.selectPermissionByUser(userId));
        }

        return permissionCache.get(userId);
    }

    @Override
    public List<Menu> getMenusByUser(Long userId) {
        return this.baseMapper.getMenusByUser(userId);
    }


}

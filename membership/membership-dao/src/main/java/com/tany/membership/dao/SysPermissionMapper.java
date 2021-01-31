package com.tany.membership.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.vo.Menu;
import com.tany.membership.vo.PermissionWithChecked;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    List<PermissionWithChecked> selectPermissionByRole(Long roleId);

    List<SysPermission> selectPermissionByUser(Long userId);

    List<Menu> getMenusByUser(Long userId);
}

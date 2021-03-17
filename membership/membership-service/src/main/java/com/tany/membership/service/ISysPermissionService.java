package com.tany.membership.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.vo.Menu;
import com.tany.membership.vo.PermissionWithChecked;

import java.util.HashMap;
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
public interface ISysPermissionService extends IService<SysPermission> {

    public static Map<Long,List<SysPermission>> permissionCache = new HashMap<>();

    List<PermissionWithChecked> getPermissionByRole(long roleId);

    List<SysPermission> getPermissionByUser(long userId);

    List<Menu> getMenusByUser(long userId);

    List<PermissionWithChecked> getPermissionList();
}

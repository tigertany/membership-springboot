package com.tany.membership.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tany.membership.common.PagedResult;
import com.tany.membership.entity.SysRole;

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
public interface ISysRoleService extends IService<SysRole> {
    List<SysRole> getRoleListByUser(long userId);
    PagedResult query(long pageIndex, long pageSize, String sortColumn, String sortMethod, Map<String,Object> search);
}

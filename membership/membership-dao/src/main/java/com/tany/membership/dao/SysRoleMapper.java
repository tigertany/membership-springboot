package com.tany.membership.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.tany.membership.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tany.membership.vo.UserWithRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> getRoleListByUser(Long userId);
}

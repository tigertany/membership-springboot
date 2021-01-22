package com.tany.membership.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tany.membership.entity.SysUser;
import com.tany.membership.vo.UserWithRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    IPage<UserWithRole> getUserList(IPage<UserWithRole> page, @Param("ew") Wrapper<UserWithRole> queryWrapper);
}

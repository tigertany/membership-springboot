package com.tany.membership.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tany.membership.dao.SysUserMapper;
import com.tany.membership.entity.SysUser;
import com.tany.membership.service.ISysUserService;
import com.tany.membership.vo.UserWithRole;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tany
 * @since 2021-01-20
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public IPage<UserWithRole> getUserList(IPage<UserWithRole> page, Wrapper<UserWithRole> queryWrapper) {
        return this.baseMapper.getUserList(page,queryWrapper);
    }
}

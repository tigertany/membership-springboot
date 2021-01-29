package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.JWTUtil;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.entity.SysUser;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AccountController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysPermissionService permissionService;

    @PostMapping("login")
    public JSONResult login(String account,String pwd)
    {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        wrapper.eq("account",account);

        SysUser user = userService.getOne(wrapper);

        if (user==null)
        {
            return JSONResult.error("无此用户!");
        }
        if (!user.getPassword().equalsIgnoreCase(pwd))
        {
            return JSONResult.error("密码错误!");
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(Constant.TOKEN_ID, JWTUtil.sign(user.getId().toString(), null,null));

        List<SysPermission> menus = permissionService.getPermissionByUser((long) user.getId());

        resultMap.put("menus",menus);

        return JSONResult.ok(resultMap);
    }

    @PostMapping("changepwd")
    public JSONResult changePassword(){
        return new JSONResult();
    }
}

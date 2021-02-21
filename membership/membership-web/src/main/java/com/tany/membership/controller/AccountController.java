package com.tany.membership.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.common.JWTUtil;
import com.tany.membership.dto.UserProfile;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.entity.SysRole;
import com.tany.membership.entity.SysUser;
import com.tany.membership.service.ISysDeptService;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.service.ISysRoleService;
import com.tany.membership.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AccountController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysPermissionService permissionService;

    @PostMapping(Constant.BASE_API_PATH+"/ex/login")
    public JSONResult doLogin(HttpServletResponse response,String account, String pwd, Boolean remember)
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

        if (remember)
        {
            Cookie cookie = new Cookie("account",user.getAccount());
            cookie.setMaxAge(30 * 24 * 60 * 60);

            response.addCookie(cookie);

        }

        Map<String, Object> resultMap = new HashMap<>();

        /*UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);

        List<SysRole> roles = roleService.getRoleListByUser(user.getId());
        userProfile.setRoles(roles);
*/
        //List<SysPermission> permissions = permissionService.getPermissionByUser(user.getId());

        resultMap.put(Constant.TOKEN_ID, JWTUtil.sign(user.getId()));
        //resultMap.put("permissions",permissions);

        return JSONResult.ok(resultMap);
    }

    @PostMapping("changepwd")
    public JSONResult changePassword(){
        return new JSONResult();
    }
}

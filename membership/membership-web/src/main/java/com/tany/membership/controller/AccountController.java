package com.tany.membership.controller;

import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.service.ISysDeptService;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.service.ISysRoleService;
import com.tany.membership.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(Constant.BASE_API_PATH)
public class AccountController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysDeptService deptService;

    @Autowired
    private ISysPermissionService permissionService;

    @PostMapping("/ex/login")
    public JSONResult doLogin(HttpServletResponse response,String account, String pwd, Boolean remember)
    {
        Map<String, Object> resultMap = new HashMap<>();

        /*UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);

        List<SysRole> roles = roleService.getRoleListByUser(user.getId());
        userProfile.setRoles(roles);
*/
        //List<SysPermission> permissions = permissionService.getPermissionByUser(user.getId());

        resultMap.put(Constant.TOKEN_ID, userService.login(account,pwd));
        if (remember)
        {
            Cookie cookie = new Cookie("account",account);
            cookie.setMaxAge(30 * 24 * 60 * 60);
            response.addCookie(cookie);
        }
        //resultMap.put("permissions",permissions);

        return JSONResult.success(resultMap);
    }

    @PostMapping("/account/{account}/changePassword")
    public JSONResult changePassword(@PathVariable("account") String account, String pwd, String newPwd){
        if(userService.changePassword(account,pwd,newPwd)){
            return JSONResult.success("密码修改成功!");
        }
        else {
            return JSONResult.fail("密码修改失败");
        }

    }
}

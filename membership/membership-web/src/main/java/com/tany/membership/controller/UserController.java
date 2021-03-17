package com.tany.membership.controller;

import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.Constant;
import com.tany.membership.common.JSONResult;
import com.tany.membership.dto.SaveUserAndRoles;
import com.tany.membership.entity.SysUserRole;
import com.tany.membership.service.ISysPermissionService;
import com.tany.membership.service.ISysUserRoleService;
import com.tany.membership.service.ISysUserService;
import com.tany.membership.vo.UserWithRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Anonymous
@RequestMapping(Constant.BASE_API_PATH)
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysUserRoleService userRoleService;
    @Autowired
    private ISysPermissionService permissionService;

    @GetMapping("/users")
    public JSONResult getUserList(Long pageIndex,Long pageSize,String sortColumn,String sortMethod,
                              @RequestParam(required = false) Map<String,Object> search)
    {
        return JSONResult.success(userService.query(pageIndex,pageSize,sortColumn,sortMethod,search));
    /*
        Page<UserWithRole> page = new Page<>(pageIndex,3); //查询第一页，查询1条数据
        //page.setSearchCount(false);

        QueryWrapper<UserWithRole> wrapper = new QueryWrapper<>();
        //设置查询条件
        for (Map.Entry<String, Object> entry : search.entrySet()) {

            if (staticParams.contains(entry.getKey())) continue;
            wrapper.like(entry.getKey(),entry.getValue());
        }


        //wrapper.like("roles_name","员");
        wrapper.eq("deleted",0);

        if (StringUtils.isNotBlank(orderAsc))
        {
            page.addOrder(OrderItem.asc(orderAsc));
        }
        if (StringUtils.isNotBlank(orderDesc))
        {
            page.addOrder(OrderItem.desc(orderDesc));
        }


        IPage<UserWithRole> iPage = userService.getUserList(page, wrapper); //userService.page(page, wrapper);
*/
//        iPage.setTotal(count);
//        System.out.println("数据总条数： " + iPage.getTotal());
//        System.out.println("数据总页数： " + iPage.getPages());
//        System.out.println("当前页数： " + iPage.getCurrent());


//        List<SIMPLE_BUSS_INFO> newList = new ArrayList<>();
//
//        for (BUSS_INFO originObj : iPage.getRecords()) {
//            newList.add(CommonUtils.entityMapping(SIMPLE_BUSS_INFO.class, originObj));
//        }



    }

    @GetMapping("/user/{id}")
    public JSONResult getUser(@RequestAttribute(value = Constant.CURUSER_ID, required = false) Long curUserId, @PathVariable Long id) {
        UserWithRole userWithRole = userService.queryById(id == null ? curUserId : id);
        if (userWithRole != null) {
            return JSONResult.success(userWithRole);
        } else {
            return JSONResult.fail("无此用户！");
        }
    }

    @GetMapping("/user/{id}/permissions")
    public JSONResult getPermissionByUser(@RequestAttribute(Constant.CURUSER_ID) Long curUserId, @PathVariable Long id) {
        return JSONResult.success(permissionService.getPermissionByUser(id == null ? curUserId : id));
    }

    @GetMapping("/user/{id}/menus")
    public JSONResult getMenuByUser(@RequestAttribute(Constant.CURUSER_ID) Long curUserId, @PathVariable Long id)
    {
        return JSONResult.success(permissionService.getMenusByUser(id == null ? curUserId : id));
    }

    @DeleteMapping("/user/{ids}")//url:delete/1,2,3
    public JSONResult delUser(@RequestAttribute(value = Constant.CURUSER_ID,required = false) Long curUserId,@PathVariable Long[] ids)
    {
        if(userService.delete(curUserId,ids))
        {
            return JSONResult.success("删除成功!");
        }
        else
        {
            return JSONResult.fail("删除失败！");
        }
    }



    @PostMapping("/user")//@RequestBody SaveUserAndRoles saveUserAndRoles
    public JSONResult save(@RequestAttribute(value = Constant.CURUSER_ID, required = false) Long curUserId,
                           @RequestBody SaveUserAndRoles saveUserAndRoles) {
        //logger.info(saveUserAndRoles.toString());

        if (userService.save(curUserId, saveUserAndRoles)) {
            return JSONResult.success("保存成功！");
        } else {
            return JSONResult.fail("保存失败！");
        }

    }

    /**
     * 修改并保存某个用户的角色
     * @param curUserId
     * @param list
     * @return
     */
    @PutMapping("/user/role")
    public JSONResult setRole(@RequestAttribute(Constant.CURUSER_ID) Long curUserId, List<SysUserRole> list) {
        JSONResult jsonResult = new JSONResult();
        //logger.info(user.toString());


        if (userRoleService.saveBatch(list)) {
            return JSONResult.success("角色保存成功！");
        } else {
            return JSONResult.fail("角色保存失败！");
        }

    }
}

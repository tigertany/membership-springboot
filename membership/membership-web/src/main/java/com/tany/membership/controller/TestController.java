package com.tany.membership.controller;

import com.tany.membership.annotation.Anonymous;
import com.tany.membership.common.JSONResult;
import com.tany.membership.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Anonymous
@RequestMapping("/test")
public class TestController {
    @Autowired
    private ISysUserService userService;

    @ResponseBody
    @GetMapping("/list")
    public JSONResult getUser()
    {
        return JSONResult.success(userService.list());
    }

    @GetMapping("/view")
    public String showView()
    {
        return "vuetify";
    }
}

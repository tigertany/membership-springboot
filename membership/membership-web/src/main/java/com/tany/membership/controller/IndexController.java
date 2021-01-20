package com.tany.membership.controller;

import com.tany.membership.annotation.Anonymous;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {

    @GetMapping("/index")
    @Anonymous
    public String index()
    {
        return "index";
    }
}

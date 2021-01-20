package com.tany.membership.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdaterController {

    @PostMapping("/update")
    public void downloadNewVersion(HttpRequest request,String[] fileInfos)
    {

    }
}

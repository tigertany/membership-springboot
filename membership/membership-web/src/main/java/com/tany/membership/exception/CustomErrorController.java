package com.tany.membership.exception;

import com.tany.membership.annotation.Anonymous;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/error")
@Anonymous
public class CustomErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return null;
	}
	
	@RequestMapping( value = "",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response) {
		int status = response.getStatus();
        switch (status){
            case 403:
                return "403";
            case 404:
                return "404错误,不存在";
            case 500:
                return "500";
        }
        return String.valueOf(status);
    }
	
	/*
	@RequestMapping(value = "", consumes="application/json;charset=UTF-8",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public  Map<String, Object> errorJson() {
        //用Map容器返回信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("rspCode", 404);
        map.put("rspMsg", "不存在");
        return map;
    }
    */

}

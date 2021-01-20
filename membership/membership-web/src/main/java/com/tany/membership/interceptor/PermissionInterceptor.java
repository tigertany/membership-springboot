package com.tany.membership.interceptor;

import com.tany.membership.annotation.Permission;
import com.tany.membership.annotation.AllowPass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PermissionInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 说明是 GET 请求是请求静态文件
	    if (!(handler instanceof HandlerMethod)) {
	        return true;
	    }

	    // 判断是否有权限
	    HandlerMethod method = (HandlerMethod) handler;
	    // 先判断 controller 类上是不是有注解 Permission
	    // 如果有注解，则每个方法都需要进行权限校验
	    Object controllerBean = method.getBean();
	    	    
	    Permission permissionOnClass = controllerBean.getClass().getAnnotation(Permission.class);
	    Permission permissionOnMethod = method.getMethodAnnotation(Permission.class);
	    
	    AllowPass allowPassOnClass = controllerBean.getClass().getAnnotation(AllowPass.class);
	    AllowPass allowPassOnMethod = method.getMethodAnnotation(AllowPass.class);

	    if (permissionOnClass != null) {
	        if (allowPassOnMethod != null) {
	            
	            return true;
	        }
	        else {
	            return checkPermission(request, response);
	        }
	    }
	    else if (allowPassOnClass != null) {
	        if (permissionOnMethod != null) {
	        	return checkPermission(request, response);
	            
	        }
	        else {
	        	return true;
	        }
	    }
	    else {
	    	if (permissionOnMethod != null) {
	        	return checkPermission(request, response);
	            
	        }
		    if (allowPassOnMethod != null) {
	        	return true;
	        }
		    return true;
		}
	    
	}

	private boolean checkPermission(HttpServletRequest request, HttpServletResponse response) {
		logger.info("权限拦截起作用");
		return true;
	}

}

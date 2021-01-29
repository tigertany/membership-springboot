package com.tany.membership.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.tany.membership.annotation.AllowPass;
import com.tany.membership.annotation.Permission;
import com.tany.membership.common.*;
import com.tany.membership.entity.SysPermission;
import com.tany.membership.service.ISysPermissionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class PermissionInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

	@Autowired
	private ISysPermissionService permissionService;

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

		String token = request.getHeader(Constant.TOKEN_ID);
		String url = request.getRequestURI().trim();

		Map<String, Claim> claimMap = JWTUtil.getClaim(token);
		if (claimMap==null)
			return false;

		String userId = claimMap.get(Constant.USER_ID).asString();
		if (StringUtils.isBlank(userId)){

			return false;
		}
		List<SysPermission> permissions = permissionService.getPermissionByUser(Long.valueOf(userId));

		for (SysPermission permission : permissions)
		{
			if (Arrays.asList(permission.getUrl().toLowerCase().split(",")).contains(url.toLowerCase())){
				return true;
			}
		}
		returnErrorResponse(response,JSONResult.error("无权限"));
		return false;

	}

	private void returnErrorResponse(HttpServletResponse response, JSONResult result) {

		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

		BufferedOutputStream bufferedOutputStream = null;
		ServletOutputStream servletOutputStream =null;

		try {
			servletOutputStream = response.getOutputStream();
			bufferedOutputStream = new BufferedOutputStream(servletOutputStream);
			bufferedOutputStream.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
			bufferedOutputStream.flush();

		} catch (Exception ex) {
			ex.printStackTrace();
			CommonUtils.printException(logger, ex);
		} finally {
			if (null != bufferedOutputStream) {
				try {
					bufferedOutputStream.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					CommonUtils.printException(logger, ex);
				}
			}
			if (null != servletOutputStream) {
				try {
					servletOutputStream.close();
				} catch (Exception ex) {
					ex.printStackTrace();
					CommonUtils.printException(logger, ex);
				}
			}
		}

	}

}

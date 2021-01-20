package com.tany.membership.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.annotation.Auth;
import com.tany.membership.common.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader(Constant.TOKEN_ID_WX);
		// 说明是 GET 请求是请求静态文件
		if (!(handler instanceof HandlerMethod)) {
			return true;
		}

		// 判断是否有权限
		HandlerMethod method = (HandlerMethod) handler;
		// 先判断 controller 类上是不是有注解 Permission
		// 如果有注解，则每个方法都需要进行权限校验
		Object controllerBean = method.getBean();

		Auth authOnClass = controllerBean.getClass().getAnnotation(Auth.class);
		Auth authOnMethod = method.getMethodAnnotation(Auth.class);

		Anonymous anonymousOnClass = controllerBean.getClass().getAnnotation(Anonymous.class);
		Anonymous anonymousOnMethod = method.getMethodAnnotation(Anonymous.class);

		if (authOnClass != null) {
			if (anonymousOnMethod != null) {
				return true;
			}
			return checkLogin(response, token);
		} else if (anonymousOnClass != null) {
			if (authOnMethod != null) {
				return checkLogin(response, token);
			}
			return true;
		} else {
			if (anonymousOnMethod != null) {
				return true;
			}
			if (authOnMethod != null) {
				return checkLogin(response, token);
			}
			return checkLogin(response, token);
		}

	}

	private Boolean checkLogin(HttpServletResponse response, String token)
			throws IOException, UnsupportedEncodingException {
		logger.info("认证拦截器:" + token);
		if (StringUtils.isBlank(token)) {
			returnErrorResponse(response, JSONResult.error("未登录,token不存在"));
			return false;
		}
		Map<String, Claim> claimMap = JWTUtil.getClaim(token);
		if (claimMap == null) {
			returnErrorResponse(response, JSONResult.error("不是有效的token0"));
			return false;
		}
		String userId = claimMap.get(Constant.USER_ID).asString();
		if (StringUtils.isBlank(userId)) {
			returnErrorResponse(response, JSONResult.error("不是有效的token1"));
			return false;
		}
		String openId = claimMap.get(Constant.OPEN_ID).asString();
		if (StringUtils.isBlank(openId)) {
			returnErrorResponse(response, JSONResult.error("不是有效的token2"));
			return false;
		}
		if (!JWTUtil.verify(token)) {
			returnErrorResponse(response, JSONResult.error("token校验失败"));
			return false;
		}
		return true;
	}

	private void returnErrorResponse(HttpServletResponse response, JSONResult result)
			throws IOException, UnsupportedEncodingException {

		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		BufferedOutputStream bufferedOutputStream = null;
		
		try {
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
				} catch (IOException ex) {
					ex.printStackTrace();
					CommonUtils.printException(logger, ex);
				}
			}
			if (null != servletOutputStream) {
				try {
					servletOutputStream.close();
				} catch (IOException ex) {
					ex.printStackTrace();
					CommonUtils.printException(logger, ex);
				}
			}
		}

	}

}

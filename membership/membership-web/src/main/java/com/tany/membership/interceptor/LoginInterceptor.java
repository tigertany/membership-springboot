package com.tany.membership.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.tany.membership.annotation.Anonymous;
import com.tany.membership.annotation.Auth;
import com.tany.membership.common.*;
import com.tany.membership.dto.UserProfile;
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
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader(Constant.TOKEN_ID);
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
            return checkLogin(request, response, token);
        } else if (anonymousOnClass != null) {
            if (authOnMethod != null) {
                return checkLogin(request, response, token);
            }
            return true;
        } else {
            if (anonymousOnMethod != null) {
                return true;
            }
            if (authOnMethod != null) {
                return checkLogin(request, response, token);
            }
            return checkLogin(request, response, token);
        }

    }

    private Boolean checkLogin(HttpServletRequest request, HttpServletResponse response, String token) {
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
        Long userId = claimMap.get(Constant.USER_ID).asLong();

        if (userId==null) {
            returnErrorResponse(response, JSONResult.error("不是有效的token1"));
            return false;
        }
        if (!JWTUtil.verify(token)) {
            returnErrorResponse(response, JSONResult.error("token校验失败"));
            return false;
        }
        request.setAttribute(Constant.CURUSER_ID, userId);

        return true;
    }

    private void returnErrorResponse(HttpServletResponse response, JSONResult result) {

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        BufferedOutputStream bufferedOutputStream = null;
        ServletOutputStream servletOutputStream = null;

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

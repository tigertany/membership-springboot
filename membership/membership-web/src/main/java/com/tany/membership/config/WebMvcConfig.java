package com.tany.membership.config;

import com.tany.membership.common.Constant;
import com.tany.membership.interceptor.LoginInterceptor;
import com.tany.membership.interceptor.MiniInterceptor;
import com.tany.membership.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${weixin.imgpath}")
    private String path;

    @Bean
    public MiniInterceptor miniInterceptor() {
        return new MiniInterceptor();
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public PermissionInterceptor permissionInterceptor() {
        return new PermissionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(miniInterceptor()).addPathPatterns(Constant.BASE_API_PATH + "/**");
        registry.addInterceptor(loginInterceptor()).addPathPatterns(Constant.BASE_API_PATH + "/**")
//			.addPathPatterns("/user/**")
//	        .addPathPatterns("/buss/**")
//		    .addPathPatterns("/weixin/**")
                .excludePathPatterns(Constant.BASE_API_PATH + "/ex/**");
        registry.addInterceptor(permissionInterceptor()).addPathPatterns(Constant.BASE_API_PATH + "/**")
                .excludePathPatterns(Constant.BASE_API_PATH + "/ex/**");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置页面转向 通过地址http://localhost:8088/hello 可以转向到templates/hello.html
        //registry.addViewController("/hello").setViewName("hello");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //资源映射处理 通过地址http://localhost:8088/images/xx 可以访问/images/目录下的资源
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/images/");
        registry.addResourceHandler("/wximgs/**").addResourceLocations("file://" + path);
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/pages");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加全局跨域配置
        registry.addMapping(Constant.BASE_API_PATH + "/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}

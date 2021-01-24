package com.tany.membership.config;

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
		registry.addInterceptor(miniInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/**")
//			.addPathPatterns("/user/**")
//	        .addPathPatterns("/buss/**")
//		    .addPathPatterns("/weixin/**")
		    .excludePathPatterns("/user/register","/user/add","/weixin/sign","/weixin/login","/weixin/getopenid");
		registry.addInterceptor(permissionInterceptor()).addPathPatterns("/**");
		
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
        registry.addResourceHandler("/wximgs/**").addResourceLocations("file://"+path);
        
    }
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加全局跨域配置
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}

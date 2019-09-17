package com.live.liveteam.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 请求拦截配置
 */
//@Configuration
public class AdminSecurityConfig extends WebMvcConfigurationSupport {

    @Bean
    UserTokenInterceptor userTokenInterceptor() {
        return new UserTokenInterceptor();
    }



    // 解决H5 options请求500错误
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

    /**
     * 自定义静态资源映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    /**
     * 拦截配置
     * 注册拦截器
     *
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册：线程拦截处理
//        registry.addInterceptor(threadLocalVariableInterceptor()).addPathPatterns("/**");

        // 注册：用户拦截
        InterceptorRegistration interceptor = registry.addInterceptor(userTokenInterceptor());
        // 用户拦截，拦截所有路径
        interceptor.addPathPatterns("/**");
        // 用户拦截，跳过swagger资源
        interceptor.excludePathPatterns("/swagger-ui.html");
        interceptor.excludePathPatterns("/webjars/**");
        interceptor.excludePathPatterns("/swagger/**");
        interceptor.excludePathPatterns("/swagger-resources/**");
        interceptor.excludePathPatterns("/v2/**");
        // 用户拦截，排除的路径

        // 后台服务接口
//        interceptor.excludePathPatterns("/manage/update_goods_cache");
    }

}

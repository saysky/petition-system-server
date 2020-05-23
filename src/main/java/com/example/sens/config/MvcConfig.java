package com.example.sens.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * <pre>
 *     拦截器，资源路径配置
 * </pre>
 */
@Slf4j
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 配置静态资源路径
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + System.getProperties().getProperty("user.home") + "/sens/upload/");
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/static/images/favicon.ico");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}

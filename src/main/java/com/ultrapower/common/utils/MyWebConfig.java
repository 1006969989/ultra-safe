package com.ultrapower.common.utils;

import com.ultrapower.framework.config.RuoYiConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 用于配置虚拟地址的配置类
 * @author 王聪
 * @date 2020-06-01
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //虚拟地址
        registry.addResourceHandler("/upload/**").addResourceLocations("file:"+RuoYiConfig.getUploadPath()+"/");
    }
}

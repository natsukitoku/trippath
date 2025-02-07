package com.example.trippath.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    //cors設定をしないと繋がらないらしい
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8081")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .allowCredentials(true);
    }
}

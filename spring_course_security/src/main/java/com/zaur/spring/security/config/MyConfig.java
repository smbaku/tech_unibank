package com.zaur.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.zaur.spring.security")
@EnableWebMvc
public class MyConfig {

  @Bean
    public ViewResolver viewResolver(){
      InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();

      internalResourceViewResolver.setPrefix("/WEB-INF/view/");
      internalResourceViewResolver.setSuffix(".jsp");

      return internalResourceViewResolver;
  }

}

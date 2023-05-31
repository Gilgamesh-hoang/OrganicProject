package com.laptrinhweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class ResourceConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/client/img/");
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/client/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/resources/client/js/");
		registry.addResourceHandler("/sass/**").addResourceLocations("/resources/client/sass/");
		registry.addResourceHandler("/paging/**").addResourceLocations("/resources/paging/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/resources/admin/assets/");
		registry.addResourceHandler("/sweetalert/**").addResourceLocations("/resources/sweetalert/");
		registry.addResourceHandler("/ckeditor/**").addResourceLocations("/resources/ckeditor/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}

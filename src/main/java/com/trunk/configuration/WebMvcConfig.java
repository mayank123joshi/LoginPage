//package com.trunk.configuration;
//
//import java.util.Locale;
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.context.support.ResourceBundleMessageSource;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = { "com.trunk.controller" })
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/WEB-INF/view/**/*").addResourceLocations(
//				"classpath:/META-INF/web-resources/");
//	}
//
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//		localeChangeInterceptor.setParamName("lang");
//		return localeChangeInterceptor;
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(localeChangeInterceptor());
//	}
//
//	@Bean(name = "localeResolver")
//	public LocaleResolver localeResolver() {
//		CookieLocaleResolver ret = new CookieLocaleResolver();
//		ret.setDefaultLocale(new Locale("en_US"));
//		return ret;
//	}
//}
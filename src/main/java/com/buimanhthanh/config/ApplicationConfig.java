package com.buimanhthanh.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import com.cloudinary.Cloudinary;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.buimanhthanh" })
public class ApplicationConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/asset/**").addResourceLocations("/asset/");
	}

	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {
				// define tiles.xml config view resolver
				"/WEB-INF/tiles-home.xml", "/WEB-INF/tiles-admin.xml" });
		tilesConfigurer.setCheckRefresh(true);
		tilesConfigurer.setCompleteAutoload(true);
		return tilesConfigurer;
	}

	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message");
		return source;
	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("UTF-8");
		return multipartResolver;
	}

	@Bean
	public Cloudinary cloudinary() {
		Map<String, Object> map = new HashMap<>();
		map.put("cloud_name", "com-buimahthanh");
		map.put("api_key", "767693717832892");
		map.put("api_secret", "prGZdfuasWtSvI2GMocQiZ9Bh9w");
		map.put("secure", true);

		Cloudinary c = new Cloudinary(map);
		return c;
	}
	/*
	 * @Bean public JavaMailSender mailSender() { JavaMailSenderImpl mailSender =
	 * new JavaMailSenderImpl(); mailSender.setHost("smtp.gmail.com");
	 * mailSender.setPort(465); mailSender.setUsername("manhthanh147@gmail.com");
	 * mailSender.setPassword("dfopunmblcxlurwv"); Properties props = new
	 * Properties(); props.put("mail.transport.protocol", "smtp");
	 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.ssl.protocols",
	 * "TLSv1.2"); props.put("mail.smtp.starttls.enable", "true");
	 * props.put("mail.debug", "true"); mailSender.setJavaMailProperties(props);
	 * return mailSender; }
	 */}

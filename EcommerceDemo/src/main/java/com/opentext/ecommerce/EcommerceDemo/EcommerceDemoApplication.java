package com.opentext.ecommerce.EcommerceDemo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.opentext.ecommerce.models.Order;
@SpringBootApplication
@ComponentScan(basePackages="com.opentext.ecommerce")
@EnableJpaRepositories(basePackages="com.opentext.ecommerce.*")
@EntityScan("com.opentext.ecommerce.*")

public class EcommerceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoApplication.class, args);
	}
	
	@Bean 
	Order getInstance()
	{
		return new Order();
	}
	
	@Bean 
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver sessionLocaleResolver=new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
		
	}
	
	@Bean
	
	public ResourceBundleMessageSource  messageSource()
	{
		ResourceBundleMessageSource messageResource= new ResourceBundleMessageSource();
		messageResource.addBasenames("messages");
		return messageResource;
	}
	
	
	
	
}

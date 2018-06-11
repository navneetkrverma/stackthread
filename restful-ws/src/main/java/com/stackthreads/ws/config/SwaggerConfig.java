package com.stackthreads.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//mark this class as a configuration for swagger
@Configuration
// enable this swagger configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * here, we have to write a bean called as docket bean, which asks what type of
	 * documentation has to be generated for APIs.
	 * 
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}

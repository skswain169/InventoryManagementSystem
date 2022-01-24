package com.accenture.lkm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MaterialServiceApplication extends SpringBootServletInitializer {

	/* Added by KZN for deploying it as war on any server */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MaterialServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MaterialServiceApplication.class, args);
	}

}

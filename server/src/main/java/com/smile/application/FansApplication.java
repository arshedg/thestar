package com.smile.application;

import java.io.IOException;

import com.smile.application.security.SecurityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FansApplication extends SpringBootServletInitializer {

	public static void main(String[] args) throws IOException {
		SecurityManager securityManager =new SecurityManager();
		securityManager.initialize();
		SpringApplication.run(FansApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FansApplication.class);
	}

}

package com.jaya.microservices.limits_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.jaya.microservices.limits_service.configuration.Configuration;

@SpringBootApplication
@EnableConfigurationProperties(Configuration.class)
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}

}

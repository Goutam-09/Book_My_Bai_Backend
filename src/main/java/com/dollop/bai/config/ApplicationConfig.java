package com.dollop.bai.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class ApplicationConfig {

	@Value("${cloud.name}")
	private String cloudName;
	@Value("${cloud.api-key}")
	private String cloudApiKey;
	@Value("${cloud.secret-key}")
	private String apiSecretKey;

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(String.format("cloudinary://%s:%s@%s",cloudApiKey,apiSecretKey,cloudName ));
	}
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}

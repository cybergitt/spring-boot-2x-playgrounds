package com.coffeegit.springboot.jpamysql.shared.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    
    @PostConstruct
    private void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC+7"));
    }

    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

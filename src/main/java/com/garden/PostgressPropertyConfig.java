package com.garden;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:database.properties")
public class PostgressPropertyConfig {
	@Value("${pg2.username}")
	private String userName;

	@Value("${pg2.password}")
	private String password;

	@Value("${pg2.dburl}")
	private String dburl;

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		return configurer;
	}
}

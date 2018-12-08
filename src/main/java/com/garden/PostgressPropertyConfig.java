package com.garden;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
// @PropertySource("classpath:database.properties")
// can use @PropertySources({
// @PropertySource("classpath:database.properties"),
// @PropertySource("classpath:jms.properties")})
public class PostgressPropertyConfig {
	@Value("${pg2.username}")
	private String userName;

	@Value("${pg2.password}")
	private String password;

	@Value("${pg2.dburl}")
	private String dburl;

//	needed only if different properties file then application.properties
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer properties() {
//		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//		return configurer;
//	}
}

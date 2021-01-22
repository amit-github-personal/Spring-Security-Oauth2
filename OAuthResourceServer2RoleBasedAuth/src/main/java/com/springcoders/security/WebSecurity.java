package com.springcoders.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@EnableWebSecurity(debug =  true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/current").hasRole("USER_INFO")
		.anyRequest().authenticated()
		.and()
		.oauth2ResourceServer()
		.jwt()
		.jwtAuthenticationConverter(jwtAuthenticationConverter());
	}
	
	JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
		authenticationConverter.setJwtGrantedAuthoritiesConverter(new GrantedAuthorityConverter());
		return authenticationConverter;
	}
	
}

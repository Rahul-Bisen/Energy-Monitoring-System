package com.app.security;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity // mandatory
@Configuration // mandatory
public class WebSecurityConfig {

	@Autowired
	private JWTRequestFilter filter;

	// configure BCryptPassword encode bean
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public PasswordDecoder decoder() {
//		
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().
		exceptionHandling().
		authenticationEntryPoint((request, response, ex) -> {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
		}).
		and().
		authorizeRequests()
		//.antMatchers("/employees").permitAll()//.hasAnyRole("ADMIN","RECEPTIONIST","DOCTOR","PATIENT","ACCOUNTANT")
		//.antMatchers("/patients").permitAll()//.hasAnyRole("ADMIN","RECEPTIONIST","DOCTOR","PATIENT","ACCOUNTANT")
		//.antMatchers("/doctors").permitAll()//.hasAnyRole("ADMIN","RECEPTIONIST","DOCTOR","PATIENT","ACCOUNTANT")
		//.antMatchers("/wards").permitAll()//.hasAnyRole("ADMIN","RECEPTIONIST","DOCTOR","PATIENT","ACCOUNTANT")
		.antMatchers( "/consumer/consumption/{id}" , "/consumer/addConsumptions", "/consumer/consumption","/auth/signin", "/auth/signup","/auth/**", "/swagger*/**", "/v*/api-docs/**").permitAll() // enabling global
																										// access to all
																										// urls with
																										// /auth
		.antMatchers("/consumer").hasRole("ADMIN")
		.antMatchers("/ele/both").hasAnyRole("ADMIN","CONSUMER")
				// only required for JS clnts (react / angular)
		.antMatchers(HttpMethod.OPTIONS).permitAll().
		anyRequest().authenticated().
		and().
		sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).
		and()
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	// configure auth mgr bean : to be used in Authentication REST controller
	@Bean
	public AuthenticationManager authenticatonMgr(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}


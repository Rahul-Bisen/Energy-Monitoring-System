package com.app.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Component
public class JWTRequestFilter extends OncePerRequestFilter {
	
	
	@Autowired
	private JwtUtils utils;
	
	//The UserDetailsService interface is typically used to load user-specific data for authentication, 
	//and it's a crucial component in Spring Security configuration, especially when working with JWT authentication.
	@Autowired
	private UserDetailsService userDetailsService;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// get authorization header n check if not null n starting with Bearer
				String header = request.getHeader("Authorization");
				
				if (header != null && header.startsWith("Bearer ")) {
					// Bearer token present --> extract n validate it
					String token = header.substring(7);
					if (utils.validateJwtToken(token)) {
						// valid token --> extract user name from the token
						String userName = utils.getUserNameFromJwtToken(token);
						System.out.println(userName);
						if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
							// load user details from UserDetailsService
							UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
							// create Authentication object , wrapping user details lifted from DB
							UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
									userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
							//set details in auth object
				//			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//							Save this authentication token in the sec ctx.
							SecurityContextHolder.getContext().setAuthentication(authentication);
						}	log.info("user name null or authentication already set , username {}",userName);

					}
				} else
					log.error("Request header DOES NOT contain a Bearer Token");
				//pass the request to the next filter in the chain
				filterChain.doFilter(request, response);
	}

}

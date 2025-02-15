package com.app.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.UserDto;
import com.app.security.JwtUtils;
import com.app.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class SignAndSignUpController {
	
	
	@Autowired
	private JwtUtils utils;
	
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request) {
		// store incoming user details(not yet validated) into Authentication object
		// Authentication i/f ---> implemented by UserNamePasswordAuthToken
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
//		log.info("auth token " + authToken);
		try {
			// authenticate the credentials
			// authenticatedDetails -> gives various authority to this class
			Authentication authenticatedDetails = manager.authenticate(authToken);
//			log.info("auth token again " + authenticatedDetails);
			// => auth succcess
			return ResponseEntity.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticatedDetails)));
		} catch (BadCredentialsException e) { // later replace this by a method in global exc handler
			// send back err resp code
			System.out.println("err " + e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}
	}
	
	
	// add request handling method for user registration
		@PostMapping("/signup")
		public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDto user) {
			System.out.println("in reg user : user " );
			// invoke service layer method , for saving : user info + associated roles info
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
		}
	
	
	
	
	

}

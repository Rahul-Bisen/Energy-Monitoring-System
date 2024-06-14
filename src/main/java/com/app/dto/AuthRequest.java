package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthRequest {
	
	@NotBlank(message = "Email can't be blank or null")
	private String email;
	@NotBlank(message = "password can't be blank or null")
	private String password;

}

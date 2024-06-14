package com.app.dto;

import com.app.entity.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsumerRequestDto {
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String address;
	
	private Roles role;

}

package com.app.dto;

import com.app.entity.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
	
	private Long userId;
	
	private String name;
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private Roles role;
	private Long consumer_id ;
	
	
	
	

}

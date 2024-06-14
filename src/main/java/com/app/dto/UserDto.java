package com.app.dto;

import com.app.entity.Roles;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	
	private String name ;
	
	private String email ;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	private Roles role ;

}

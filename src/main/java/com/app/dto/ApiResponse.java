package com.app.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
public class ApiResponse {
	
	private String message ;
	
	private LocalDateTime time ;

	public ApiResponse(String message) {
		super();
		this.message = message;
		this.time = LocalDateTime.now();
	}

	public ApiResponse() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

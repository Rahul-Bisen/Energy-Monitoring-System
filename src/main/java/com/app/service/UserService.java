package com.app.service;

import java.util.List;

import com.app.dto.ConsumptionResponseDto;
import com.app.dto.UserDto;
import com.app.entity.Users;

public interface UserService {
	
	Users addUser(UserDto user);

//	List<ConsumptionResponseDto> findConsumptionDetailsByUserId(Long userId);
//	
	

}

package com.app.service;

import java.util.List;

import com.app.dto.ChartData;
import com.app.dto.ConsumerDetailsDto;
import com.app.dto.ConsumerDto;
import com.app.dto.ConsumerRequestDto;
import com.app.dto.ConsumptionRequestDto;
import com.app.dto.ConsumptionResponseDto;
import com.app.dto.LoginRequest;
import com.app.dto.UserDetails;
import com.app.entity.Consumer;
import com.app.entity.Consumption;

public interface ConsumerService {

	List<ConsumerDto> fetchaAllConsumers();

	

	String addNewConsumer(ConsumerRequestDto dto);
	
	

	

	UserDetails authenticate(LoginRequest req);



	List<Consumption> getAllData();



	ConsumerDetailsDto findConsumerDetailsById(Long id);



	ChartData findChartDataById(Long id);



	String addConsumptionsData(ConsumptionRequestDto dto);



//	List<Consumption> fetchConsumptionDataByConsumerId(Long consumer_id);
	
	List<ConsumptionResponseDto> fetchConsumptionDataByConsumerId(Long consumer_id);



	Long findConsumerIdByUserId( Long userId);





}

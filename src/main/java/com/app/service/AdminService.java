package com.app.service;

import java.util.List;

import com.app.dto.ConsumptionResponseDto;

public interface AdminService {

	 List<ConsumptionResponseDto> getConsumptionChartData();

}

package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ConsumptionResponseDto;
import com.app.entity.Consumption;
import com.app.repository.BillingRepository;



@Transactional
@Service
public class AdminServiceImpl implements AdminService {
	
	
	@Autowired
	private BillingRepository billingRepo;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ConsumptionResponseDto> getConsumptionChartData() {
		// TODO Auto-generated method stub
		
		List<Consumption> list = billingRepo.findAll();
		List<ConsumptionResponseDto> responsedto = new ArrayList<ConsumptionResponseDto>();
		
				for( Consumption c : list) {
					
					ConsumptionResponseDto dto = modelMapper.map(c, ConsumptionResponseDto.class);
					dto.setConsumer_id(c.getConsumer().getConsumer_Id());
					responsedto.add(dto);
					
				}
		
		
		return responsedto;
	}
	
	
	

}

package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.ResourceNotFoundException;
import com.app.dto.ChartData;
import com.app.dto.ConsumerDetailsDto;
import com.app.dto.ConsumerDto;
import com.app.dto.ConsumerRequestDto;
import com.app.dto.ConsumptionRequestDto;
import com.app.dto.ConsumptionResponseDto;
import com.app.dto.LoginRequest;
import com.app.dto.UserDetails;
import com.app.dto.UserDto;
import com.app.entity.Consumer;
import com.app.entity.Consumption;
import com.app.entity.Users;
import com.app.repository.BillingRepository;
import com.app.repository.ConsumerRepository;
import com.app.repository.UserRepository;



@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService{
	
	@Autowired
	private UserRepository uRepo;
	
	
	
	
	@Autowired
	private BillingRepository billingRepo;
	
	@Autowired
	private ConsumerRepository consumerRepo;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public String addNewConsumer(ConsumerRequestDto dto) {
		
		Users user = userService.addUser(modelMapper.map(dto, UserDto.class));
		
		Consumer consumer = modelMapper.map(dto, Consumer.class);
		consumer.setUser(user);
		
		consumerRepo.save(consumer);
		
	   
		return "Consumer Added Successfully";
		// TODO Auto-generated method stub
		
		
		
//		Consumer consumer = modelMapper.map(dto, Consumer.class);
//		return consumerRepo .save(consumer);
	}

	@Override
	public List<ConsumerDto> fetchaAllConsumers() {
		// TODO Auto-generated method stub
		
		List<Consumer> listt = consumerRepo.findAll();
		
		List<ConsumerDto> dtolist = listt.stream()
		        .map(cust -> {
		            ConsumerDto dto = new ConsumerDto();
		            dto.setConsumer_id(cust.getConsumer_Id());
		            dto.setName(cust.getName());
		            dto.setAddress(cust.getAddress());
		            return dto;
		        })
		        .collect(Collectors.toList());
		
		return dtolist ; 
	}

	@Override
	public UserDetails authenticate(LoginRequest req) {
		// TODO Auto-generated method stub
		
		Users  cuns = uRepo.findByEmailAndPassword(req.getEmail(),req.getPassword()).get();
		UserDetails dto = modelMapper.map(cuns, UserDetails.class);
		
		
		
		return dto;
	}

	@Override
	public List<Consumption> getAllData() {
		// TODO Auto-generated method stub
		List<Consumption> list = billingRepo.findAll();
		return list;
	}

	@Override
	public ConsumerDetailsDto findConsumerDetailsById(Long id) {
//		Optional<Consumer> consumerOptional = consumerRepo.findById(id);
//        Consumer consumer = consumerOptional.orElseThrow(() -> new ResourceNotFoundException("Consumer not found"));
//
//        // Fetch the Consumption entity
//        List<Consumption> consumption = billingRepo.findByConsumerId(consumer.getConsumer_Id());
//
//        // Map the Consumer and Consumption entities to the ConsumerDetailsDto
//        ConsumerDetailsDto dto = new ConsumerDetailsDto();
//        dto.setConsumer_Id(consumer.getConsumer_Id());
//        dto.setName(consumer.getName());
//        dto.setAddress(consumer.getAddress());
//        
//
//        if (consumption != null) {
//        	dto.setConsumption_id(id);
//            dto.setYears(consumption.getYears());
//            dto.setJan(consumption.getJan());
//            dto.setFeb(consumption.getFeb());
//            dto.setMar(consumption.getMar());
//            dto.setApril(consumption.getApril());
//            dto.setMay(consumption.getMay());
//            dto.setJune(consumption.getJune());
//            dto.setJuly(consumption.getJuly());
//            dto.setAugust(consumption.getAugust());
//            dto.setSept(consumption.getSept());
//            dto.setOct(consumption.getOct());
//            dto.setNov(consumption.getNov());
//            dto.setDec(consumption.getDec());
//        } else {
//            throw new ResourceNotFoundException("Consumption details not found");
//        }

        return null;
	}

	@Override //not in use
	public ChartData findChartDataById(Long id) {
		
        Consumption consumption = billingRepo.findById(id).orElseThrow(()->
        new ResourceNotFoundException("data dont exits"));
        
        ChartData dto = new ChartData();
        dto.setJan(consumption.getJan());
        dto.setFeb(consumption.getFeb());
        dto.setMar(consumption.getMar());
        dto.setApril(consumption.getApril());
        dto.setMay(consumption.getMay());
        dto.setJune(consumption.getJune());
        dto.setJuly(consumption.getJuly());
        dto.setAugust(consumption.getAugust());
        dto.setSept(consumption.getSept());
        dto.setOct(consumption.getOct());
        dto.setNov(consumption.getNov());
        dto.setDec(consumption.getDec());
        
        return dto ; 

		
	}

	@Override
	public String addConsumptionsData(ConsumptionRequestDto dto) {
		// TODO A
		Consumption cons = modelMapper.map(dto, Consumption.class);
		cons.setConsumer(consumerRepo.findById(dto.getConsumer_Id()).get());
		
		billingRepo.save(cons);
		return "New ConsumptionsAdded";
		
		
		
	}

//	@Override //workingg
//	public List<Consumption> fetchConsumptionDataByConsumerId(Long consumer_id) {
//		// TODO Auto-generated method stub
//		
//		Consumer consumer = consumerRepo.findById(consumer_id).get();
//		
//		List<Consumption> consumptionLists = billingRepo.findConsumptionsByConsumerId(consumer.getConsumer_Id());
//		
//		
//		return consumptionLists;
//	}
	
	@Override // try 
	public List<ConsumptionResponseDto> fetchConsumptionDataByConsumerId(Long consumer_id) {
		// TODO Auto-generated method stub
		
		Consumer consumer = consumerRepo.findById(consumer_id).get();
		
		List<Consumption> consumptionLists = billingRepo.findConsumptionsByConsumerId(consumer.getConsumer_Id());
		List<ConsumptionResponseDto> dtolist = new ArrayList<ConsumptionResponseDto>();
		
		for ( Consumption c : consumptionLists) {
			ConsumptionResponseDto dtto = modelMapper.map(c , ConsumptionResponseDto.class);
			dtto.setConsumer_id(consumer.getConsumer_Id());
			dtolist.add(dtto);
			
		}
		
		
		return dtolist ;
	}

	@Override
	public Long findConsumerIdByUserId( Long userId) {
		// TODO Auto-generated method stub
		
		Consumer consumer = consumerRepo.findByUserUserId(userId).get();
		return consumer.getConsumer_Id();
	}

	

	

}

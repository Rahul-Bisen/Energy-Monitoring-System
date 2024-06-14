package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.ConsumptionResponseDto;
import com.app.dto.UserDto;
import com.app.entity.Consumer;
import com.app.entity.Consumption;
import com.app.entity.Users;
import com.app.repository.BillingRepository;
import com.app.repository.ConsumerRepository;
import com.app.repository.UserRepository;
import static com.app.dto.ConsumptionResponseDto.consumptionList;



@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ConsumerRepository consumerRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private BillingRepository consumptionRepo;
	
	
	
	
	
	
	@Override
	public Users addUser(UserDto user) {
		// TODO Auto-generated method stub
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		return userRepo.save(modelMapper.map(user, Users.class));
	}







//	@Override
//	public List<ConsumptionResponseDto> findConsumptionDetailsByUserId(Long userId) {
//		// TODO Auto-generated method stub
//		Users user = userRepo.findById(userId).get();
//		Consumer consumer = consumerRepo.findConsumerByUserid(user.getUserId());
//		List<Consumption> consumptionlist = consumptionRepo.findByConsumerId(consumer.getConsumer_Id());
//		
//		return consumptionList(consumptionlist);
//	}

}

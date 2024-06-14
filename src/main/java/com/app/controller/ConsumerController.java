package com.app.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.ConsumerDto;
import com.app.dto.ConsumerRequestDto;
import com.app.dto.ConsumptionRequestDto;
import com.app.dto.LoginRequest;
import com.app.entity.Consumer;
import com.app.entity.Users;
import com.app.service.ConsumerService;
import com.app.service.UserService;

@RestController
@RequestMapping("/consumer")
@CrossOrigin(origins = "*")
public class ConsumerController {
	
	
	@Autowired
	private ConsumerService consumerService ;
	
	@Autowired
	private UserService userService;
	
	// get All Consumers
	@GetMapping // working
	public ResponseEntity<?> getAllConsumers(){
		try {
		return new ResponseEntity<>(consumerService.fetchaAllConsumers(), HttpStatus.OK);
	}catch(RuntimeException e) {
		System.out.println(e);
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ApiResponse(e.getMessage()));
		
	}
	}
	
	@GetMapping("/consumption")
	public ResponseEntity<?> getAllElectricConsumptionData(){
		try {
		return new ResponseEntity<>(consumerService.getAllData(),HttpStatus.OK);
	
		}catch(RuntimeException e) {
			System.out.println(e);
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ApiResponse(e.getMessage()));
			
		}
		}
	
//	@GetMapping("/consumer/{id}") // 
//	public ResponseEntity<?> getConsumerDetailsById(@PathVariable(value = "id") Long id ){
//		
//		 if (id == null) {
//		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("The given id must not be null!"));
//		    }
//
//		
//		try {
//		return new ResponseEntity<>(eservice.findConsumerDetailsById(id),HttpStatus.OK);
//	}catch(RuntimeException e) {
//		System.out.println(e);
//		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ApiResponse(e.getMessage()));
//		
//	}
//	}
	
	@GetMapping("/chartdata/{id}")
	public ResponseEntity<?> chartData(@PathVariable(value = "id") Long id ){
		
		if (id == null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("The given id must not be null!"));
	    }

	
	try {
	return new ResponseEntity<>(consumerService.findChartDataById(id),HttpStatus.OK);
}catch(RuntimeException e) {
	System.out.println(e);
	return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ApiResponse(e.getMessage()));
	
}
	}
	
//	@GetMapping("/{id}") //noww
//	public ResponseEntity<?> getConsumptionDetailsByConsumptionId(@PathVariable ( value = "id") Long userId){
//		
//		 
//		return   new ResponseEntity<>( userService.findConsumptionDetailsByUserId(userId), HttpStatus.OK);
//		
//	}
	
	
	@PostMapping // working
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest req){
		try {
		return new ResponseEntity<>(consumerService.authenticate(req),HttpStatus.OK);
	}catch(RuntimeException e) {
		System.out.println(e);
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ApiResponse(e.getMessage()));
		
	}
	
		
		
		
	}
	
	
	@PostMapping("/addConsumer") // working
	public ResponseEntity<?> addNewConsumer(@RequestBody ConsumerRequestDto dto){
		try {
		return new ResponseEntity<>(consumerService.addNewConsumer(dto), HttpStatus.OK);
	}catch(RuntimeException e) {
		System.out.println(e);
		return  ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ApiResponse(e.getMessage()));
		
	}
	}
	
	@PostMapping("/addConsumptions")
	public ResponseEntity<?> addConsumptionsData( @RequestBody ConsumptionRequestDto dto){
		
		return new ResponseEntity<>(consumerService.addConsumptionsData(dto), HttpStatus.OK);
	}
	
	@GetMapping("/consumption/{consumer_id}")
	public ResponseEntity<?> getConsumptionDataByConsumerId(@PathVariable("consumer_id") Long consumer_id ){
		
		return new ResponseEntity<>(consumerService.fetchConsumptionDataByConsumerId(consumer_id), HttpStatus.OK);
	}
	
	

}

package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customException.ResourceNotFoundException;
import com.app.dto.LoginRequest;
import com.app.dto.LoginRequestDto;
import com.app.dto.UserResponseDto;
import com.app.entity.Consumer;
import com.app.entity.Users;
import com.app.repository.ConsumerRepository;
import com.app.repository.UserRepository;
import com.app.service.ConsumerService;
import com.app.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService service;

	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private ConsumerRepository consumerRepo;

	@Autowired
	private ModelMapper modelMapper;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@PostMapping("/login")
	public ResponseEntity<?> getUserDetails(@RequestBody LoginRequestDto dto) {

		Long roleId;

		Users user = userRepo.findByEmail(dto.getEmail())
				.orElseThrow(() -> new ResourceNotFoundException("Does not find User with Given email Id"));

//		//day 20
//		Consumer consumer = consumerRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(() ->
//		new ResourceNotFoundException("Does not find User with Given email Id"));
//		
		if (encoder.matches(dto.getPassword(), user.getPassword())) {

			if (user.getRole().name().equals("ROLE_CONSUMER")) {

				roleId = consumerService.findConsumerIdByUserId(user.getUserId());

				UserResponseDto Consumerdto = modelMapper.map(user, UserResponseDto.class);
				Consumerdto.setConsumer_id(roleId);

				return new ResponseEntity<>(Consumerdto, HttpStatus.OK);

			} else if (user.getRole().name().equals("ROLE_ADMIN")) {

				UserResponseDto dtto = modelMapper.map(user, UserResponseDto.class);

				return new ResponseEntity<>(dtto, HttpStatus.OK);

			} else {
				throw new ResourceNotFoundException("Invalid Password");
			}

		} else {
			throw new ResourceNotFoundException("password incorrect");
		}

	}

}

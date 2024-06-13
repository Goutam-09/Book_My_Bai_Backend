package com.dollop.bai.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.dtos.LoginDto;
import com.dollop.bai.dtos.UserDto;
import com.dollop.bai.dtos.UserPasswordBody;
import com.dollop.bai.services.IAuthServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookmybai")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private IAuthServices userServices;
	
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> registerUser(
			@Valid
			@RequestBody UserDto userDto){
		return new ResponseEntity<ApiResponse>(userServices.registerUser(userDto),HttpStatus.CREATED);
	}

	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser(
			@Valid
			@RequestBody LoginDto loginDto){
		return new ResponseEntity<Map<String, Object>>(userServices.loginUser(loginDto),HttpStatus.OK);
	}
	
	
	@GetMapping("/currentuser/{userId}")
	public ResponseEntity<Map<String, Object>> currentUser(
			@PathVariable String userId
			){
		return new ResponseEntity<Map<String,Object>>(userServices.getCurrentUser(userId),HttpStatus.OK);
	}
	
	
	@PatchMapping("/change/password")
	public ResponseEntity<Map<String, Object>> changePassword(
			@Valid
			@RequestBody UserPasswordBody userPasswordBody
			){
		return new ResponseEntity<Map<String,Object>>(userServices.changePassword(userPasswordBody),HttpStatus.OK);
	}
	
}

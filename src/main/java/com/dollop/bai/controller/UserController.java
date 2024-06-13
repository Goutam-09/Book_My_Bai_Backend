package com.dollop.bai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.dtos.UserDto;
import com.dollop.bai.services.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookmybai")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PatchMapping("/update/{userId}")
	public ResponseEntity<ApiResponse> updateUser(
			@Valid
			@RequestBody UserDto userDto,
			@PathVariable String userId
			) {
		return new ResponseEntity<ApiResponse>(userService.updateUser(userDto, userId),HttpStatus.OK);
	}
}

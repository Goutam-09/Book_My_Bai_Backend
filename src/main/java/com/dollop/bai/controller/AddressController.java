package com.dollop.bai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dollop.bai.dtos.AddressDto;
import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.services.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookmybai/")
@CrossOrigin("*")
public class AddressController {

	@Autowired
	private IAddressService addressService;
	
	@PostMapping("saveaddress/{userId}")
	public ResponseEntity<ApiResponse> createAddress(
			@PathVariable String userId,
			@Valid
			@RequestBody AddressDto addressDto
			) {
		return new ResponseEntity<ApiResponse>(addressService.createAddress(addressDto, userId),HttpStatus.CREATED);
	}
}

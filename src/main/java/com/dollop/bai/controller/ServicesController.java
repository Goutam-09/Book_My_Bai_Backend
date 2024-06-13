package com.dollop.bai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.bai.dtos.PageableResponse;
import com.dollop.bai.dtos.ServicesDto;
import com.dollop.bai.services.IServicesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookmybai")
@CrossOrigin("*")
public class ServicesController {

	@Autowired
	private IServicesService servicesService;
	
	@PostMapping("/create/service")
	public ResponseEntity<?> createServices(
			@Valid
			@RequestPart(value = "serviceDtos") String serviceDtos,
			@RequestPart(value = "file",required = false) MultipartFile image
			){
		ServicesDto servicesDto = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			servicesDto = mapper.readValue(serviceDtos, ServicesDto.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(servicesService.createServices(servicesDto,image),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllServices")
	public ResponseEntity<PageableResponse<ServicesDto>> getAllServices(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "serviceName", required = false) String sortBy,
			@RequestParam(value = "sortDirection", defaultValue = "asc", required = false) String sortDirection
			){
		return new ResponseEntity<PageableResponse<ServicesDto>>(servicesService.getAllServices(pageNumber, pageSize, sortBy, sortDirection),HttpStatus.OK);
	}
	
	@GetMapping("/singleservice/{serviceName}")
	public ResponseEntity<?> getSingleService(
			@PathVariable String serviceName
			){
		return new ResponseEntity<>(servicesService.getSingleService(serviceName),HttpStatus.OK);
	}
}

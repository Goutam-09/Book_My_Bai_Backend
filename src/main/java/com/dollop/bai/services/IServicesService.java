package com.dollop.bai.services;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.dollop.bai.dtos.PageableResponse;
import com.dollop.bai.dtos.ServicesDto;

public interface IServicesService {

	public Map<String, Object> createServices(ServicesDto servicesDto,MultipartFile image);
	public Map<String, Object> getSingleService(String serviceName);
	public PageableResponse<ServicesDto> getAllServices(int pageNumber, int pageSize, String sortBy, String sortDirection);
	
}

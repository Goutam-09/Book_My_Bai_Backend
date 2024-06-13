package com.dollop.bai.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dollop.bai.constants.AppConstants;
import com.dollop.bai.dtos.PageableResponse;
import com.dollop.bai.dtos.ServicesDto;
import com.dollop.bai.exceptions.DublicateEntryException;
import com.dollop.bai.exceptions.ResourceNotFoundException;
import com.dollop.bai.file.ICloudService;
import com.dollop.bai.helper.Helper;
import com.dollop.bai.model.Services;
import com.dollop.bai.repositories.ServicesRepository;
import com.dollop.bai.services.IServicesService;


@Service
public class ServicesServiceImpl implements IServicesService {

	@Autowired
	private ServicesRepository servicesRepository;
	
	@Autowired
	private ICloudService cloudService;
	
	private Services services;
	
	private Map<String, Object> map;
	
	
	@Override
	public Map<String, Object> createServices(ServicesDto servicesDto,MultipartFile image) {
		
		if(servicesRepository.existsByServiceName(servicesDto.getServiceName()))
			throw new DublicateEntryException(AppConstants.DUBLICATE_SERVICE);
		System.err.println(servicesDto.getServiceShiftsArray());
		services = Services.builder()
				.serviceName(servicesDto.getServiceName())
				.serviceRate(servicesDto.getServiceRate())
				.serviceShiftsArray(servicesDto.getServiceShiftsArray())
				.serviceCategoryArray(servicesDto.getServiceCategoryArray())
				.build();
		if(image!=null) {
			String imageName = cloudService.uploadFileInFolder(image, AppConstants.SERVICE_IMAGE_PATH);
			services.setServiceImage(imageName);
		}
		services = servicesRepository.save(services);
		if(services.getServiceId()!=null) {
			map = new HashMap<>();
			map.put(AppConstants.MESSAGE, AppConstants.SERVICE_ADDED);
		}
		return map;
	}


	@Override
	public PageableResponse<ServicesDto> getAllServices(int pageNumber, int pageSize, String sortBy, String sortDirection) {
		Sort sort = (sortDirection.equalsIgnoreCase("desc"))?
				(Sort.by(sortBy).descending()):
				(Sort.by(sortBy).ascending());
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		Page<Services> page = servicesRepository.findAll(pageable);
		PageableResponse<ServicesDto> response = Helper.getPageableResponse(page,ServicesDto.class);
		return response;
	}


	@Override
	public Map<String, Object> getSingleService(String serviceName) {
		
		services = servicesRepository.findByServiceName(serviceName).orElseThrow(
				()->new ResourceNotFoundException(AppConstants.SERVICE_NOT_FOUND)
				);
		ServicesDto servicesDto = ServicesDto.builder()
				.serviceId(services.getServiceId())
				.serviceName(services.getServiceName())
				.serviceImage(services.getServiceImage())
				.serviceShiftsArray(services.getServiceShiftsArray())
				.serviceCategoryArray(services.getServiceCategoryArray())
				.serviceRate(services.getServiceRate())
				.build();
		map = new HashMap<>();
		map.put("servicesDto", servicesDto);
		return map;
	}
	


}

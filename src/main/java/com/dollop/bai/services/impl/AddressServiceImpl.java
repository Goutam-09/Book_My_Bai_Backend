package com.dollop.bai.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dollop.bai.constants.AppConstants;
import com.dollop.bai.dtos.AddressDto;
import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.exceptions.ResourceNotFoundException;
import com.dollop.bai.model.Address;
import com.dollop.bai.model.User;
import com.dollop.bai.repositories.AddressRepository;
import com.dollop.bai.repositories.UserRepository;
import com.dollop.bai.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AddressRepository addressRepository;
	private User user = null;
	private Address address = null;
	private ApiResponse apiResponse = null;
	@Override
	public ApiResponse createAddress(AddressDto addressDto, String userId) {
		user = userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND)
				);
		if(user.getAddress()!=null) {
			address = Address.builder()
					.addressId(user.getAddress().getAddressId())
					.Country(addressDto.getCountry())
					.state(addressDto.getState())
					.city(addressDto.getCity())
					.street(addressDto.getStreet())
					.zipCode(addressDto.getZipCode())
					.user(new User(user.getUserId()))
					.build();
		}
		else {
			address = Address.builder()
					.Country(addressDto.getCountry())
					.state(addressDto.getState())
					.city(addressDto.getCity())
					.street(addressDto.getStreet())
					.zipCode(addressDto.getZipCode())
					.user(new User(user.getUserId()))
					.build();
		}
		address = addressRepository.save(address);
		if(address.getAddressId()!=null) {
		apiResponse = ApiResponse.builder()
				.success(Boolean.TRUE)
				.message(AppConstants.ADD_ADDRESS)
				.status(HttpStatus.CREATED)
				.build();
		}
		return apiResponse;
	}

}

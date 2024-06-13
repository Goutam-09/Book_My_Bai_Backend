package com.dollop.bai.services;

import com.dollop.bai.dtos.AddressDto;
import com.dollop.bai.dtos.ApiResponse;

public interface IAddressService {
	public ApiResponse createAddress(AddressDto addressDto,String userId);
}

package com.dollop.bai.services;

import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.dtos.UserDto;

public interface IUserService {

	public ApiResponse updateUser(UserDto userDto,String userId);
}

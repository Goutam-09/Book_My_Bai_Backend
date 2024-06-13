package com.dollop.bai.services;
import java.util.Map;

import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.dtos.LoginDto;
import com.dollop.bai.dtos.UserDto;
import com.dollop.bai.dtos.UserPasswordBody;

public interface IAuthServices {

	public ApiResponse registerUser(UserDto userDto);
	public Map<String, Object> loginUser(LoginDto loginDto);
	public Map<String, Object> getCurrentUser(String userId);
	public Map<String, Object> changePassword(UserPasswordBody userPasswordBody);
}

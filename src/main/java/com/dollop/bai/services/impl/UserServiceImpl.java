package com.dollop.bai.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dollop.bai.constants.AppConstants;
import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.dtos.UserDto;
import com.dollop.bai.exceptions.ResourceNotFoundException;
import com.dollop.bai.model.User;
import com.dollop.bai.repositories.UserRepository;
import com.dollop.bai.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	private ApiResponse apiResponse = null;
	private User user = null;
	@Override
	public ApiResponse updateUser(UserDto userDto, String userId) {
		
		user = userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND)
				);
		user.setUserName(userDto.getUserName());
		user.setUserGender(userDto.getUserGender());
		user = userRepository.save(user);
		if(user.getUserId()!=null) {
			apiResponse = ApiResponse.builder()
					.success(Boolean.TRUE)
					.message(AppConstants.USER_UPDATE)
					.status(HttpStatus.OK)
					.build();
		}
		return apiResponse;
	}

}

package com.dollop.bai.services.impl;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dollop.bai.constants.AppConstants;
import com.dollop.bai.dtos.ApiResponse;
import com.dollop.bai.dtos.LoginDto;
import com.dollop.bai.dtos.UserDto;
import com.dollop.bai.dtos.UserPasswordBody;
import com.dollop.bai.exceptions.DublicateEntryException;
import com.dollop.bai.exceptions.ResourceNotFoundException;
import com.dollop.bai.model.Roles;
import com.dollop.bai.model.User;
import com.dollop.bai.model.UserRoles;
import com.dollop.bai.repositories.UserRepository;
import com.dollop.bai.repositories.UserRolesRepo;
import com.dollop.bai.services.IAuthServices;

@Service
public class AuthServiceImpl implements IAuthServices{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRolesRepo userRolesRepo;
	private ApiResponse response = null;
	
	private UserRoles userRoles ;

	private User user = null;
	
	private Map<String, Object> map = null;
	
	@Override
	public ApiResponse registerUser(UserDto userDto) {
		if(userRepository.existsByUserEmail(userDto.getUserEmail()))
			throw new DublicateEntryException(AppConstants.EMAIL_ALREADY_REGISTERED);
		
		if(userRepository.existsByUserMobile(userDto.getUserMobile()))
			throw new DublicateEntryException(AppConstants.MOBILE_ALREADY_REGISTERED); 
		
		if(userRepository.count()<1) {
			userRoles = new UserRoles();
			userRoles.setUserRoleId(UUID.randomUUID().toString());
			userRoles.setUserRole(Roles.ADMIN);
			 user = User.builder()
					.userName(userDto.getUserName())
					.userMobile(userDto.getUserMobile())
					.userEmail(userDto.getUserEmail())
					.userGender(userDto.getUserGender())
					.isActive(userDto.getIsActive())
					.userPassword(userDto.getUserPassword())
					.build();
			user.setUserRoles(Arrays.asList(userRoles));
			userRoles.setUsers(Arrays.asList(user));
		}
		else {
			userRoles = new UserRoles();
			 user = User.builder()
					.userName(userDto.getUserName())
					.userMobile(userDto.getUserMobile())
					.userEmail(userDto.getUserEmail())
					.userGender(userDto.getUserGender())
					.isActive(userDto.getIsActive())
					.userPassword(userDto.getUserPassword())
					.build();
			
			if(userRolesRepo.existsByUserRole(Roles.CUSTOMER)){
				
				Optional<UserRoles> optional = userRolesRepo.findByUserRole(Roles.CUSTOMER);				
				System.err.println(optional.get());
				user.setUserRoles(Arrays.asList(optional.get()));
				userRoles.setUsers(Arrays.asList(user));
			}
			else {
				userRoles.setUserRoleId(UUID.randomUUID().toString());
				userRoles.setUserRole(Roles.CUSTOMER);
				user.setUserRoles(Arrays.asList(userRoles));
				userRoles.setUsers(Arrays.asList(user));
			}
		}
		user = userRepository.save(user);
		if(user.getUserId()!=null) {
			response = ApiResponse.builder()
					.success(Boolean.TRUE)
					.message(AppConstants.REGISTRATION_SUCCESSFULLY) 
					.status(HttpStatus.CREATED).build();
		}
		return response;
	}

	@Override
	public Map<String, Object> loginUser(LoginDto loginDto) {
			User user = userRepository.findByUserEmailAndUserPasswordAndIsActive(loginDto.getUserEmail(),loginDto.getUserPassword(),Boolean.TRUE).orElseThrow(
					()-> new ResourceNotFoundException(AppConstants.INVALID_CREDENTIAL));
			map = new HashMap<>();
			if(user.getUserId()!=null) {
				map.put("user",user.getUserId());
			}
			return map;
	}

	@Override
	public Map<String, Object> getCurrentUser(String userId) {
		user = userRepository.findById(userId).orElseThrow(
				()-> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND)
				);
		map = new HashMap<>();
		UserDto userDto = UserDto.builder()
				.userId(user.getUserId())
				.userName(user.getUserName())
				.userMobile(user.getUserMobile())
				.userEmail(user.getUserEmail())
				.userGender(user.getUserGender())
				.userRoles(user.getUserRoles())
				.isActive(user.getIsActive())
				.address(user.getAddress())
				.build();
		map.put("currentUser", userDto);
		return map;
	}

	@Override
	public Map<String, Object> changePassword(UserPasswordBody userPasswordBody) {
		
		user = userRepository.findById(userPasswordBody.getUserId()).orElseThrow(
				()-> new ResourceNotFoundException(AppConstants.USER_NOT_FOUND)
				);
		map = new HashMap<>();
		if(!(user.getUserPassword().equals(userPasswordBody.getCurrentPassword()))) {
			throw new ResourceNotFoundException(AppConstants.CURRENT_PASSWORD_INVALID);
		}
		
		if(user.getUserPassword().equals(userPasswordBody.getNewPassword())) {
			throw new ResourceNotFoundException(AppConstants.NEW_PASSWORD_MATCH_ERROR);
		}
		 user.setUserPassword(userPasswordBody.getNewPassword());
		 user = userRepository.save(user);
	     map.put(AppConstants.MESSAGE, AppConstants.PASSWORD_UPDATED);
		 return map;
	}
	
	

}

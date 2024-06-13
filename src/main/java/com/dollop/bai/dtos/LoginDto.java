package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Address;
import com.dollop.bai.model.UserRoles;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {

	private String userId;
	private String userName;
	@NotBlank
	@Email
	private String userEmail;
	private String userMobile;
	@NotBlank
	@Size(min = 6,max = 15)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$")
	private String userPassword;
	private String userGender;
	private List<UserRoles> userRoleDto;
	private Boolean isActive=true;
}

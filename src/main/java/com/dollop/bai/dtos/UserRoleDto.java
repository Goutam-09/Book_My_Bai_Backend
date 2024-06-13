package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Roles;
import com.dollop.bai.model.User;
import jakarta.validation.constraints.NotBlank;
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
public class UserRoleDto {

	private String userRoleId;
	@NotBlank
	private Roles userRole;
	private Boolean isActive=true;
	private List<User> users; 
}

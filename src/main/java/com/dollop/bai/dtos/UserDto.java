package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Address;
import com.dollop.bai.model.Booking;
import com.dollop.bai.model.Maid;
import com.dollop.bai.model.UserRoles;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class UserDto {

	private String userId;
	@NotBlank
	@Size(min = 3,max = 35)
	@Pattern(regexp = "^[A-Za-z]+(?:[-\\s][A-Za-z]+)*$")
	private String userName;
	@NotBlank
	@Size(min = 10,max = 13)
	@Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{9,11}$")
	private String userMobile;
	@NotBlank
	@Email
	private String userEmail;
	
	@Size(min = 6,max = 15)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$")
	private String userPassword;
	@NotBlank
	@Size(min = 1,max = 6)
	private String userGender;

	private Boolean isActive=true;
	
	private List<UserRoles> userRoles;

	private Address address;
	
	private List<Booking> booking;
}

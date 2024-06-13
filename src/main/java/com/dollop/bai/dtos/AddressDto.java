package com.dollop.bai.dtos;

import com.dollop.bai.model.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class AddressDto {

	
	private String addressId;
	@Pattern(regexp = "^[A-Za-z0-9,. ]*$")
	private String street;
	@Pattern(regexp = "^[A-Za-z ]*$")
	private String city;
	private String zipCode;
	@Pattern(regexp = "^[A-Za-z ]*$")
	private String country;
	@Pattern(regexp = "^[A-Za-z ]*$")
	private String state;
	private User user;
}

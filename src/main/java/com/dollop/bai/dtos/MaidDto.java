package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Areas;
import com.dollop.bai.model.Booking;
import com.dollop.bai.model.Services;

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
public class MaidDto {

	private String maidId;
	@NotBlank
	@Size(min = 3,max = 15)
	@Pattern(regexp = "^[A-Za-z]+(?:[-\\s][A-Za-z]+)*$")
	private String maidName;
	@NotBlank
	@Email
	private String maidEmail;
	@NotBlank
	@Size(min = 1,max = 6)
	private String maidGender;
	@NotBlank
	@Size(min = 10,max = 12)
	@Pattern(regexp = "^[0-9]{3}[-\\s]?[0-9]{3}[-\\s]?[0-9]{4}$")
	private String maidMobile;
	@NotBlank
	@Size(min = 3,max = 20)
	@Pattern(regexp = "^[0-9]{3}[-\\s]?[0-9]{3}[-\\s]?[0-9]{4}$")
	private String occupation;
	@NotBlank
	@Size(min = 3,max = 20)
	@Pattern(regexp = "^[A-Za-z]+(?:[-\\s][A-Za-z]+)*$")
	private String registerAs;
	@NotBlank
	@Size(min = 6,max = 12)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{6,}$")
	private String password;

	private Boolean policeVerification = false;

	private Boolean isActive = true;

	private List<Services> services;

	private List<Booking> bookings;

	private List<Areas> areas;
}

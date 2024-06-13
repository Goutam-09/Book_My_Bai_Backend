package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Maid;
import com.dollop.bai.model.Payment;
import com.dollop.bai.model.Services;
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
public class BookingDto {

	private String bookingId;
	@NotBlank
	private String bookingFrom;
	@NotBlank
	private String bookingTo;

	private User user;

	private Maid maid;
	
	private List<Services> services;

	private Payment payment;
}

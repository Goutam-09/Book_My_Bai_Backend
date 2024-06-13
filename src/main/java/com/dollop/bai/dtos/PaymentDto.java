package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Booking;

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
public class PaymentDto {

	private String paymentId;
	private List<Booking> bookings;
}

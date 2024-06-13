package com.dollop.bai.dtos;

import com.dollop.bai.model.Services;
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
public class TimeSlotsDto {

	private String timeSlotId;
	@NotBlank
	private String time;
	
	private Services services;
}

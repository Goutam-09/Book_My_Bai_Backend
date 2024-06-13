package com.dollop.bai.dtos;

import java.util.List;
import java.util.Set;

import com.dollop.bai.model.Areas;
import com.dollop.bai.model.Booking;
import com.dollop.bai.model.Maid;
import com.dollop.bai.model.TimeSlots;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
public class ServicesDto {

	private String serviceId;
	@NotBlank
	@Pattern(regexp = "^[A-Za-z]+(?:[-\\s][A-Za-z]+)*$")
	private String serviceName;
	private String serviceImage;
    @DecimalMin(value = "0")
    @DecimalMax(value = "9999999")
	private Double serviceRate;
    private Set<String> serviceCategoryArray;
    @NotBlank
    private Set<String> serviceShiftsArray;
	private List<TimeSlots> timeSlots;
	private List<Maid> maids;
	private List<Areas> areas;
	private List<Booking> bookings;
}

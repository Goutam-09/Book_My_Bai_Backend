package com.dollop.bai.dtos;

import java.util.List;

import com.dollop.bai.model.Maid;
import com.dollop.bai.model.Services;

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
public class AreasDto {

	private String areaId;
	@NotBlank
	private String area;
	@NotBlank
	@Pattern(regexp = "^(?:RS|rs)?[0-9]*$")
	private Double areaRate;
	private List<Services> services;
	private Maid maid;
}

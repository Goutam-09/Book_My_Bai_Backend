package com.dollop.bai.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Entity
public class ServiceRequirementDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String serviceReqId;
	@Column(length = 15)
	private String customerType;
	@Column(length = 30)
	private String propertyType;
	private Double propertySize;
	private Integer noOfMembers;
	@Column(length = 20)
	private String serviceName;
	private String serviceShift;
	@OneToOne
	private Services services;
	
	
	
}

package com.dollop.bai.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String bookingId;

	private String bookingFrom;
	private String bookingTo;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "maid")
	private Maid maid;
	
	@ManyToMany
	@JoinTable(
			name = "booking_services",
			joinColumns = @JoinColumn(name="booking_id"),
			inverseJoinColumns = @JoinColumn(name="service_id")
			)
	private List<Services> services;
	
	@ManyToOne
	@JoinColumn(name = "payment")
	private Payment payment;

	
}

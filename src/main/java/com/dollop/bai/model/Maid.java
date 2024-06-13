package com.dollop.bai.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Maid implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String maidId;
	
	@Column(length = 35)
	private String maidName;
	
	@Column(unique = true)
	private String maidEmail;
	
	@Column(length = 6)
	private String maidGender;
	
	@Column(length = 12,unique = true)
	private String maidMobile;
		
	@Column(length = 15)
	private String occupation;
	
	@Column(length = 10)
	private String registerAs;
	
	@Column(length = 12)
	private String password;
	
	private Boolean policeVerification=false;
	
	private Boolean isActive=true;
	
	@ManyToMany
	@JoinTable(
			name = "maid_services",
			joinColumns = @JoinColumn(name="maid_id"),
			inverseJoinColumns = @JoinColumn(name="service_id")
			)	
	private List<Services> services;
	
	@OneToMany(mappedBy = "maid")
	private List<Booking> bookings;

	@OneToMany(mappedBy = "maid")
	private List<Areas> areas;
}

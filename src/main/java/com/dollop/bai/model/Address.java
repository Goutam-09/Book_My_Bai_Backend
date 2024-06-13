package com.dollop.bai.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String addressId;
	@Column(length = 30)
	private String street;
	@Column(length = 30)
	private String city;
	@Column(length = 10)
	private String zipCode;
	@Column(length = 255)
	private String Country;
	@Column(length = 255)
	private String state;
	@OneToOne
	@JoinColumn(name = "user")
	@JsonIgnore
	private User user;
}

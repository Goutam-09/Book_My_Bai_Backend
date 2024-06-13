package com.dollop.bai.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String serviceId;
	@Column(length = 20,unique = true)
	private String serviceName;
	private Double serviceRate;
	@ElementCollection
	@CollectionTable(
			name = "Service_category_table",
			joinColumns = @JoinColumn(name = "service_id")
			)
	private Set<String> serviceCategoryArray;
	
	@ElementCollection
	@CollectionTable(
			name = "Service_shift_table",
			joinColumns = @JoinColumn(name = "service_id")
			)
	private Set<String> serviceShiftsArray;
	@Column(unique = true)
	private String serviceImage;
	
	@OneToMany(mappedBy = "services",fetch = FetchType.LAZY)
	private List<TimeSlots> timeSlots;
	
	@ManyToMany(mappedBy = "services")
	private List<Maid> maids;
	
	@ManyToMany
	@JoinTable(
			name = "area_services",
			joinColumns = @JoinColumn(name="service_id"),
			inverseJoinColumns = @JoinColumn(name="area_id")
			)
	private List<Areas> areas;
	
	@ManyToMany(mappedBy = "services")
	private List<Booking> bookings;
}

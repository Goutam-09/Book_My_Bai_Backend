package com.dollop.bai.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class User implements Serializable{

	public User(String userId2) {
		this.userId = userId2;
	}

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String userId;
	@Column(length = 18)
	private String userName;
	@Column(length = 13,unique = true)
	private String userMobile;
	@Column(unique = true)
	private String userEmail;
	@Column(length = 12)
	private String userPassword;
	@Column(length = 6)
	private String userGender;
	private Boolean isActive=true;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_role_table",
			joinColumns = @JoinColumn(name = "user"),
			inverseJoinColumns = @JoinColumn(name = "user_roles")
			)
	private List<UserRoles> userRoles;
	

	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> booking;
	
	
}

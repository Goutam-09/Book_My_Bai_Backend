package com.dollop.bai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.bai.model.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}

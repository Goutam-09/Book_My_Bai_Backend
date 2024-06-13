package com.dollop.bai.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dollop.bai.model.Services;

public interface ServicesRepository extends JpaRepository<Services, String> {

	public Boolean existsByServiceName(String serviceName);

	public Optional<Services> findByServiceName(String serviceName);

}

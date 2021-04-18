package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.CustomerLogin;

public interface CustomerLoginRepository extends JpaRepository<CustomerLogin,String>{

	Optional<CustomerLogin> findByName(String name);
	

}

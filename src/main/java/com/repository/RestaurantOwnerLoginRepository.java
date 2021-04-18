package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.RestaurantOwnerLogin;

public interface RestaurantOwnerLoginRepository extends JpaRepository<RestaurantOwnerLogin,String>{

	
	Optional<RestaurantOwnerLogin> findByName(String name);
}

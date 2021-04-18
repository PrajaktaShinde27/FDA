package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.model.Restaurant;


public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
	Optional<Restaurant> findByrname(String rname);

	@Query("select rname from Restaurant")
	List<String> findAllrname();

	
}

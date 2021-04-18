package com;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Restaurant;
import com.repository.RestaurantRepository;
import com.service.RestaurantService;
@SpringBootTest
public class RestaurantTests {

	
	@MockBean
	private RestaurantRepository rrepo;
	
	@Autowired
	private RestaurantService restaurantServices;
	
	
	// For Restaurant
			@Test
			public void getAllRestaurants() 
			{
				Restaurant restaurant=new Restaurant();
				restaurant.setRid(2);
				restaurant.setRname("paradise");
				restaurant.setAddress("kukatpally");
				restaurant.setContactNo("8686759209");
				Restaurant restaurant1=new Restaurant();
				restaurant1.setRid(5);
				restaurant1.setRname("paradogy");
				restaurant1.setAddress("kukatpalli");
				restaurant1.setContactNo("8686759229");
				List<Restaurant> RestaurantList = new ArrayList<>(); 
				RestaurantList.add(restaurant);
				RestaurantList.add(restaurant1);
				Mockito.when(rrepo.findAll()).thenReturn(RestaurantList);
				assertThat(restaurantServices.getListOfRestaurants()).isEqualTo(RestaurantList);
			}
}

package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Cart;
import com.model.Item;
import com.model.Restaurant;
import com.service.RestaurantService;


@RequestMapping("/restaurant")
@RestController
public class RestaurantController {
	
	@Autowired(required=true)
	RestaurantService restServices;
	
  // List of Restaurants---in detail
	@GetMapping("/getRestaurant")
	public ResponseEntity <List<Restaurant>> getRestaurant() 
	{
		List<Restaurant> le1= restServices.getListOfRestaurants();
		ResponseEntity re=new ResponseEntity <List<Restaurant>>(le1,HttpStatus.OK);
		return re;
	}
	
	//List of Resaurants---only names
	@GetMapping("/getRestaurantlist")
	public ResponseEntity <List<String>> getRestaurants() 
	{
		List<String> le2= restServices.getRestaurantList();
		ResponseEntity re=new ResponseEntity <List<String>>(le2,HttpStatus.OK);
		return re;
	}
	
	//Restaurant by ID
	@GetMapping("/getRestaurants/{rid}")
	public ResponseEntity <Restaurant> getARestaurantById(@PathVariable int rid)
	{
		Restaurant le3= restServices.getListById(rid);
		ResponseEntity re=new ResponseEntity <Restaurant>(le3,HttpStatus.OK);
		return re;
	}
	
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<Restaurant> addRestaurant(@Valid  @RequestBody Restaurant r)
	{
		Restaurant le4=restServices.createRestaurant(r);
		ResponseEntity re1=new ResponseEntity<Restaurant>(le4,HttpStatus.OK);
		return re1;
	}
	
	
	@PutMapping("/updateRestaurant")
	public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant i) throws Exception
	{
		Restaurant le5=restServices.updateRestaurant(i);
		ResponseEntity re1=new ResponseEntity<Restaurant>(le5,HttpStatus.OK);
		return re1;
	}
	
	@DeleteMapping("/deleteRestaurant/{rid}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable int rid) throws Exception
	{
		String le6=restServices.deleteRestaurantById(rid);
		
		ResponseEntity re1=new ResponseEntity<String>(le6,HttpStatus.OK);
		return re1;
	}
	

	
	@DeleteMapping("/deleteAllitemfromRestaurant/{rid}")
	public ResponseEntity<String> deleteitemsfromrest(@PathVariable int rid )throws Exception
	{
		String le7=restServices.deleteAllItemsFromRestaurant(rid);
		 ResponseEntity re= new ResponseEntity<String>(le7,new HttpHeaders(),HttpStatus.OK);
			return re;
		
	}
	
	
}

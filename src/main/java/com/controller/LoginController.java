package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advices.UsernameNotExistException;
import com.model.CustomerLogin;
import com.model.RestaurantOwnerLogin;
import com.service.LoginService;


@RestController
@RequestMapping("/api2")
public class LoginController {
	
	@Autowired
	LoginService ls;
	
	//For Customer
	
	@PostMapping("/RegisterationOfCustomer")
	public ResponseEntity<CustomerLogin> registerCustomer(@RequestBody CustomerLogin l)
	{
		String l1=ls.registerationOfCustomer(l);
		ResponseEntity re=new ResponseEntity<String>(l1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping("/LoginOfCustomer") 
	public ResponseEntity<CustomerLogin> loginCustomer(@RequestBody CustomerLogin l) throws Exception
	{
		String l2=ls.loginOfCustomer(l);
		ResponseEntity re=new ResponseEntity<String>(l2,HttpStatus.OK);
		return re;
	}

	//For Restaurant
	
		@PostMapping("/RegisterationOfRestaurantOwner")
		public ResponseEntity<RestaurantOwnerLogin> registerRestaurantOwner(@RequestBody RestaurantOwnerLogin l)
		{
			String l3=ls.registerationOfRestaurantOwner(l);
			ResponseEntity re=new ResponseEntity<String>(l3,HttpStatus.OK);
			return re;
		}
		
		@PostMapping("/LoginOfRestaurantOwner") 
		public ResponseEntity<RestaurantOwnerLogin> loginRestaurantOwner(@RequestBody RestaurantOwnerLogin l) throws Exception
		{
			String l4=ls.loginOfRestaurantOwner(l);
			ResponseEntity re=new ResponseEntity<String>(l4,HttpStatus.OK);
			return re;
		}
	

}

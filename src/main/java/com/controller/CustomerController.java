package com.controller;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.model.Customer;
import com.service.CustomerService;
import com.service.ItemService;
import com.service.RestaurantService;

@RestController
@RequestMapping("/api4")
public class CustomerController {
	@Autowired
	ItemService is;
	@Autowired
	RestaurantService rs;
    @Autowired
	CustomerService cservice;
    
	
    
	@GetMapping(path="/getCustomerById/{id}") 
	public ResponseEntity <Customer> getCustomerBy(@PathVariable int id) throws Exception
	{
		Customer cust1= cservice.getCustomerById(id);
		ResponseEntity custre=new ResponseEntity <Customer>(cust1,HttpStatus.OK);
		return  custre;
	}
	
	@PostMapping(path="/addCustomer")
	public ResponseEntity <Customer> addCustomer(@Valid @RequestBody Customer ls )
	{
		Customer cust2=cservice.addCustomer(ls);
		ResponseEntity custre1=new ResponseEntity <Customer> (cust2,HttpStatus.OK);
		return custre1;
	}

	
	@PutMapping(path="/updateCustomer")
	public ResponseEntity <Customer> updateCustomer(@RequestBody Customer up) throws Exception
	{
		Customer cust3=cservice.updateCustomer(up);
		ResponseEntity custre2=new ResponseEntity <Customer> (cust3,HttpStatus.OK);
		return custre2;
	}
		
	
	@DeleteMapping(path="/deleteCutomerById/{Customerid}")
	public ResponseEntity<String> deleteCustomerById (@PathVariable int Customerid) throws Exception
	{
		String cust4=cservice.deleteCustomerById(Customerid);
		ResponseEntity custre3=new ResponseEntity<String>(cust4,HttpStatus.OK);
		return custre3;
	}
	
 
	@GetMapping("/getRestaurantlist")
	public ResponseEntity <List<String>> getRestaurants() 
	{
		List<String> cust5= rs.getRestaurantList();
		ResponseEntity custre4=new ResponseEntity <List<String>>(cust5,HttpStatus.OK);
		return custre4;
	}
	
	
}

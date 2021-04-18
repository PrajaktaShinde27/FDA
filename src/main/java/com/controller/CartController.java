package com.controller;


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
import com.service.CartService;

@RestController
@RequestMapping("/api3")
public class CartController {
	
	
	@Autowired
	CartService cs;
	
	
	@PostMapping("/createcart")
	public ResponseEntity<Cart> createCart(@RequestBody Cart c)
	{
		Cart c1=cs.createCart(c);
		
		ResponseEntity re=new ResponseEntity<Cart>(c1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping("/deletecart/{cid}")
	public ResponseEntity<Cart> deleteCart(@PathVariable int cid) throws Exception
	{
		String c2=cs.deleteCartById(cid);
	    ResponseEntity re1= new ResponseEntity<String>(c2,new HttpHeaders(),HttpStatus.OK);
		return re1;
	}
	

	
	@GetMapping("/getcartdetails/{cid}")
	public ResponseEntity<Cart> getCart(@PathVariable int cid) throws Exception
	{
		Cart c3=cs.getCartDetails(cid);
	    ResponseEntity re2= new ResponseEntity<Cart>(c3,new HttpHeaders(),HttpStatus.OK);
		return re2;
	}
	
	@PutMapping("/additemstocart")
	public ResponseEntity<Cart> itemsInCart(@RequestBody Cart c )throws Exception
	{
		Cart c4=cs.addItemsToCart(c);
		 ResponseEntity re3= new ResponseEntity<Cart>(c4,new HttpHeaders(),HttpStatus.OK);
			return re3;
		
	}
	
	@DeleteMapping("/deleteitemsfromcart/{cid}")
	public ResponseEntity<String> itemsOutFromCart(@PathVariable int cid )throws Exception
	{
		String c5=cs.deleteCartItems(cid);
		 ResponseEntity re4= new ResponseEntity<String>(c5,new HttpHeaders(),HttpStatus.OK);
			return re4;
		
	}
	
}

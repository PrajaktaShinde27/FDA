package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.model.Payment;
import com.service.PaymentService;

@Controller
@RequestMapping("/api1")
public class PaymentController {
	@Autowired
	PaymentService ps;
	
	@PostMapping("/createpay")
	public ResponseEntity<Payment> createPay(@RequestBody Payment p) throws Exception
	{
		Payment p1=ps.createPayment(p);
		
		ResponseEntity re=new ResponseEntity<Payment>(p1,HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping(path="/getPayment/{pid}")
	public ResponseEntity<Payment> getPayDetails(@PathVariable int pid)throws Exception
	{
		Payment p2=ps.displayPaymentDetails(pid);
	    ResponseEntity re= new ResponseEntity<Payment>(p2,new HttpHeaders(),HttpStatus.OK);
		return re;
	}
	
	
	@DeleteMapping("/deletePayment/{pid}") 
	public ResponseEntity<Payment> deletePay(@PathVariable int pid) throws Exception
	{
		String p3=ps.deletePayment(pid);
	    ResponseEntity re= new ResponseEntity<String>(p3,new HttpHeaders(),HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getallPayment")
	//@ResponseBody
	public ResponseEntity<List<Payment>> getAllPay()
	{
		List<Payment> p4=ps.allPaymentDetails();
		ResponseEntity re= new ResponseEntity<List<Payment>>(p4,new HttpHeaders(),HttpStatus.OK);
		return re;
	}

}

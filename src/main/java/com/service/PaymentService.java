package com.service;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.CartIdNotExistException;
import com.advices.CartIsEmptyException;
import com.advices.PayIdNotExistException;
import com.model.Cart;
import com.model.Payment;
import com.repository.CartRepository;
import com.repository.CustomerRepository;
import com.repository.PaymentRepository;

@Service
public class PaymentService {

	List <Payment> le;
	@Autowired(required=true)
	PaymentRepository pr;
	
	@Autowired(required=true)
	CartRepository cr;
	

	
	//Create Payment for particular cartid
	public Payment createPayment(Payment p) throws Exception
	{
		Payment p1=new Payment();
		Payment p2=new Payment();
		 Supplier<Exception>s2 = ()->new CartIdNotExistException("Cart Id is not present in the database to Update");
		  Cart c3=cr.findById(p.getCart().getCart_id()).orElseThrow(s2);
		  
		 
		  if(c3.getItems().isEmpty())
		  {
			  
			  throw new CartIsEmptyException("Cart is empty so cant make payment");
			 
		  }
		  else
		  {
		  p1.setPayment_mode(p.getPayment_mode());
		  p1.setCart(c3);
		  p1.setTotal_cost(c3.getTotal_cost());
		  p1.setDt(p.getDt());
		  p2=pr.save(p1);
		  }
		  
		return p2;
	}

	//Payment by its paymentId
	public Payment displayPaymentDetails(int pid) throws Exception
	{
		Supplier<Exception> s1 = ()->new PayIdNotExistException("Payment id is not present in the database to retrieve");
		Payment p2=pr.findById(pid).orElseThrow(s1);
		
		return p2;
		
	}
	
	//List of all Payments
	public List<Payment> allPaymentDetails()
	{
		le=new ArrayList<>();
		le=pr.findAll();
		
		return le;
	}
	
	
	//Delete Payment by Id
	public String deletePayment(int pid) throws Exception
	{
		Supplier<Exception> s1 = ()->new PayIdNotExistException("Payment id is not present in the database to delete");
		Payment p3=pr.findById(pid).orElseThrow(s1);
		
		pr.deleteById(pid);
	    return "Deleted";
	}
	

	
	
	
}

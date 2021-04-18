package com;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Cart;
import com.model.Customer;
import com.model.Item;
import com.model.Payment;
import com.repository.PaymentRepository;
import com.service.PaymentService;

@SpringBootTest
public class PaymentTests {
	
	@Autowired
	private PaymentService pservice;
	
	@MockBean
	private PaymentRepository pr;

	
	@Test
	public void testDisplayPaymentDetails() throws Exception
	{
		Cart c=new Cart();
		c.setCart_id(100);
		c.setItems(null);
		c.setTotal_cost(0);
		Payment p=new Payment();
		p.setPayment_id(101);
		p.setPayment_mode("cash");
		p.setDt(new Date());
		p.setCart(c);
		p.setTotal_cost(c.getTotal_cost());
		
Optional<Payment> payment1=Optional.ofNullable(p);
		
	    Mockito.when(pr.findById(101)).thenReturn(payment1);
	    assertThat(pservice.displayPaymentDetails(101)).isEqualTo(p);

		
	}
	
	@Test
	public void testAllPaymentDetails() throws Exception
	{
		Cart c=new Cart();
		c.setCart_id(100);
		c.setItems(null);
		c.setTotal_cost(0);
		Payment p=new Payment();
		p.setPayment_id(101);
		p.setPayment_mode("cash");
		p.setDt(new Date());
		p.setCart(c);
		p.setTotal_cost(c.getTotal_cost());
		
		Cart c1=new Cart();
		c1.setCart_id(200);
		c1.setItems(null);
		c1.setTotal_cost(10);
		Payment p1=new Payment();
		p1.setPayment_id(101);
		p1.setPayment_mode("cash");
		p1.setDt(new Date());
		p1.setCart(c);
		p1.setTotal_cost(c1.getTotal_cost());
		
		
		
		List<Payment> payList = new ArrayList<>(); 
		payList.add(p);
		payList.add(p1);
		
	    Mockito.when(pr.findAll()).thenReturn(payList);
	    
	    assertThat(pservice.allPaymentDetails()).isEqualTo(payList);
	}
	
}

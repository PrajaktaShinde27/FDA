package com;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.model.Customer;
import com.repository.CustomerRepository;
import com.service.CustomerService;


@SpringBootTest
public class CustomerTests {
	
	//For Customer
	
	@Autowired
	private CustomerService cservice;
	
	@MockBean
	private CustomerRepository cr;
	

	@Test
	public void testGetCustomerById() throws Exception{
		Customer customer = new Customer();
		customer.setCustomer_id(101);
		customer.setFirst_name("Neha");
		customer.setLast_name("Shinde");
		customer.setGender("Female");
		customer.setContact_number("9812217456");
		customer.setAddress("Pune,Maharashtra");
		Optional<Customer> customer1=Optional.ofNullable(customer);
		
	    Mockito.when(cr.findById(101)).thenReturn(customer1);
	    assertThat(cservice.getCustomerById(101)).isEqualTo(customer);

}


  @Test 
  public void testUpdateCustomer() throws Exception {
	  Customer customer =  new Customer();
      customer.setCustomer_id(83); 
      customer.setFirst_name("Neha");
      customer.setLast_name("Dhupia"); 
      customer.setGender("Female");
      customer.setContact_number("8974623512"); 
      customer.setAddress("Pune,Maharashtra");
      Optional<Customer> customer1=Optional.ofNullable(customer);
  
  Mockito.when(cr.findById(83)).thenReturn(customer1);

  Mockito.when(cr.save(customer)).thenReturn(customer);
  assertThat(cservice.updateCust(83, "Nisha")).isEqualTo(customer);
	  
  }
 
 
//Delete, need to rework	
  @Test 
  public void testDeleteCustomer()throws Exception{
  Customer customer=new   Customer();
  customer.setCustomer_id(101); 
  customer.setFirst_name("Sayali");
  customer.setLast_name("Patil"); 
  customer.setGender("Female");
  customer.setContact_number("9756432345");
  Optional<Customer>  customer1=Optional.ofNullable(customer);
  Mockito.when(cr.findById(101)).thenReturn(customer1);
  assertFalse(cservice.deleteCustomerById(customer.getCustomer_id()));
  verify(cr,times(1)).deleteById(customer.getCustomer_id());
//Mockito.verify(cr.findById(101));

  
  }

  
  
  
  
  
  
  
  //@Test
	//public void deleteCabTest() {
		//Cab cab = new Cab(3, "Sedan", 11);
		//service.deleteCab(cab.getCabId());
		//verify(repository, times(1)).deleteById(cab.getCabId());
	//}

  
  
  
  
  
  
  

private void assertFalse(String deleteCustomerById) {
	// TODO Auto-generated method stub
	
}

}

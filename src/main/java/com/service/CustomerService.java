package com.service;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.CustomerNotFoundException;
import com.model.Customer;
import com.repository.CustomerRepository;

@Service
public class CustomerService {
	
	List<Customer> le;
	
	@Autowired
	CustomerRepository cusrepo;
	
	@Autowired
	CartService cs;
	
	//To get List of Customers
	  public List<Customer> getCustomers() 
	  {
	  le=new ArrayList(); 
	  le=cusrepo.findAll(); 
	  return le;
	  
	  }
	 	
	//Get Customer by particular Customer ID
	public Customer getCustomerById(int custid) throws Exception {
		Supplier<Exception> s2=()-> new CustomerNotFoundException ("Customer is not present in the database");
		Customer c1= cusrepo.findById(custid).orElseThrow(s2);
		 return c1;			
	}
	
	//Add a Customer
	public Customer addCustomer(Customer ls)
	{
		Customer c1=cusrepo.save(ls);
		
		return c1;
		
	}
		
	//Update Customer
	public Customer updateCustomer(Customer up) throws Exception
	{
		int id=up.getCustomer_id();
		Supplier<Exception> s1=()-> new CustomerNotFoundException ("Customer is not present in the database");
		Customer c1=cusrepo.findById(id).orElseThrow(s1);
		Customer customer=new Customer();
		customer.setCart(c1.getCart());
	//	customer.setCart(cs.updateCartDetails(c1.getCart()));
		customer.setFirst_name(up.getFirst_name());
		customer.setAddress(up.getAddress());
		customer.setContact_number(up.getContact_number());
		customer.setCustomer_id(up.getCustomer_id());
		customer.setLast_name(up.getLast_name());
		customer.setGender(up.getGender());

		return cusrepo.save(customer);
		
	}
	
	//Delete Customer by Customer Id
	public String deleteCustomerById(int Customerid) throws Exception {
		Supplier<Exception> s2=()-> new CustomerNotFoundException ("Customer is not present in the database");
		Customer s=cusrepo.findById(Customerid).orElseThrow(s2);
		cusrepo.deleteById(Customerid);
		//cs.deleteCartById((Customerid+1));
		return "Deleted";
	}
	
	//For testing
	public Customer updateCust(Integer custId, String firstname) {
		Customer custfromdb = cusrepo.findById(custId).orElse(null);
		custfromdb.setFirst_name(firstname);
		Customer updatedcust = cusrepo.save(custfromdb);
		return updatedcust;
	}
	
}

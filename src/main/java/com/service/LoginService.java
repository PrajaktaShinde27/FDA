package com.service;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.UsernameNotExistException;
import com.model.CustomerLogin;
import com.model.RestaurantOwnerLogin;
import com.repository.CustomerLoginRepository;
import com.repository.RestaurantOwnerLoginRepository;

@Service
public class LoginService  {
	
	@Autowired(required=true)
	CustomerLoginRepository lr;
	
	@Autowired(required=true)
	RestaurantOwnerLoginRepository rol;

	
	//Registration of Customer
	public String registerationOfCustomer(CustomerLogin l) {
		String value=null;
	
		if(lr.findByName(l.getName()).isEmpty())
		{
			
			String username=l.getName();
			String password=l.getPass();
			String regex="^[A-Z]{1}+[A-Za-z0-9]*[@.#]{1}+[A-Za-z0-9]*$";
			String regex2="^[A-Z]{1}+[A-Za-z0-9]*[@.#]{1}+[A-Za-z0-9]*$";
	 	if(username.length()==8 && password.length()==8)
			{
				if(username.matches(regex))
				{
					if(password.matches(regex2))
					{
						
						value="Correct Username and Password Validations. Registration Successfull";
						CustomerLogin l1=lr.save(l);
					}
					else
					{
						value="Wrong password validations";
					}
				}
				else
				{
					value="Incorrect username validation";
				}
			}
			else
			{
				
				value="Incorrect length";
			}
			
		}
		else{
		Optional<CustomerLogin> lo=lr.findByName(l.getName());
			
			 if((l.getName()).equals((lo.get().getName())))
				{
					value="Username Already Exists";
				}
			}		

		return value;
	}

	//Login Of Customer
	public String loginOfCustomer(CustomerLogin l) throws Exception 
	{
		String value=null; 
		Supplier<Exception> s2=()->new UsernameNotExistException("Username not exists. Register first");
		CustomerLogin l2=lr.findByName(l.getName()).orElseThrow(s2);
		String dbpass=l2.getPass();
		 if(l.getPass().equals(dbpass))
		    {
		    	value="Login Successful";
		    }
		    else
		    {
		    	value="Login Unsuccessful";
		    }
			
			return value;
	}
	
	
	

	//Registration of RestaurantOwner
	
	public String registerationOfRestaurantOwner(RestaurantOwnerLogin l) {
		String value=null;
	
		if(rol.findByName(l.getName()).isEmpty())
		{
			
			String username=l.getName();
			String password=l.getPass();
			String regex3="^[A-Z]{1}+[A-Za-z0-9]*[@.#]{1}+[A-Za-z0-9]*$";
			String regex4="^[A-Z]{1}+[A-Za-z0-9]*[@.#]{1}+[A-Za-z0-9]*$";
	 	if(username.length()==8 && password.length()==8)
			{
				if(username.matches(regex3))
				{
					if(password.matches(regex4))
					{
						
						value="Correct Username and Password Validations. Registration Successful";
						RestaurantOwnerLogin rl=rol.save(l);
					}
					else
					{
						value="Wrong password validations";
					}
				}
				else
				{
					value="Incorrect username validation";
				}
			}
			else
			{
				
				value="Incorrect length";
			}
			
		}
		else{
		Optional<RestaurantOwnerLogin> lo=rol.findByName(l.getName());
			
			 if((l.getName()).equals((lo.get().getName())))
				{
					value="Username Already Exists";
				}
			}
		
				

		return value;
	}

	//Login of Restaurant Owner
	public String loginOfRestaurantOwner(RestaurantOwnerLogin l) throws Exception 
	{
		String value=null; 
		Supplier<Exception> s2=()->new UsernameNotExistException("Username not exists. Register first");
		RestaurantOwnerLogin l2=rol.findByName(l.getName()).orElseThrow(s2);
		String dbpass=l2.getPass();
		 if(l.getPass().equals(dbpass))
		    {
		    	value="Login Successful";
		    }
		    else
		    {
		    	value="Login Unsuccessful";
		    }
			
			return value;
		 
	}
	
	
	//Logout of Customer or Restaurant Owner
	public String logout()
	{
		return"Logout Successful";
	}

}

package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.RestIdNotFoundException;
import com.advices.RestNameNotFoundException;
import com.model.Customer;
import com.model.Item;
import com.model.Restaurant;
import com.repository.RestaurantRepository;


@Service
public class RestaurantService {
	
	ItemService is;
	List<String> restname;

	List<Restaurant> restaurants;
	@Autowired(required=true)
	RestaurantRepository restrepo;
	
	//get List Of Restaurants
	public List<Restaurant> getListOfRestaurants()
	{
		restaurants=new ArrayList<>();
		restaurants=restrepo.findAll();
		return restaurants;
	}
	
	//get Restaurant by its Id
	public Restaurant getListById(int restId)
	{
		Restaurant r1=restrepo.findById(restId).orElse(null);
		return r1;
	}
	
	//create restaurant
	public Restaurant createRestaurant(Restaurant r)
	{
		Restaurant r1=restrepo.save(r);
		return r1;
	}
	
	//Update Restaurant
	//@SuppressWarnings("unused")
	public Restaurant updateRestaurant(Restaurant r) throws Exception
	{
		int restid=r.getRid();
		Supplier<Exception> s1=()->new RestIdNotFoundException("Restaurant Id is not present in the database");
		Restaurant r1=restrepo.findById(restid).orElseThrow(s1);
		r1.setRid(r.getRid());
		r1.setRname(r.getRname());
		r1.setAddress(r.getAddress());
		r1.setContactNo(r.getContactNo());
		  List<Item> items=r1.getItems(); 
		  for(Item i:r.getItems()) 
		  {
			  items.add(i);
	  	} 
		//  System.out.println(items);
		  
		  r1.setItems(items);
		 
		restrepo.save(r1);
		return r1;
	}

	
	//Delete Restaurant By Id
	@SuppressWarnings("unused")
	public String deleteRestaurantById(int rid) throws Exception {
		Supplier<Exception> s1=()->new RestIdNotFoundException("Restaurant Id is not present in the database to delete");
		Restaurant r1=restrepo.findById(rid).orElseThrow(s1);
		
		restrepo.deleteById(rid);
		return "Deleted";
		
	}
	
	
	//Get List Of Restaurant
	public List<String> getRestaurantList() {
		restname=new ArrayList();
        restname=restrepo.findAllrname();
		return restname;
		
	}
	
	
	//DeleteAllItems
	public String deleteAllItemsFromRestaurant(int rid) throws Exception {
		Supplier<Exception> s1=()->new RestIdNotFoundException("Restaurant Id is not present in the database so no items present to delete");
		Restaurant r1=restrepo.findById(rid).orElseThrow(s1);
	//	r1.getItems().clear();
		List<Item> items=r1.getItems();
		items.removeAll(items);
		restrepo.save(r1);
		return "Deleted";
	}
	
	
	
	
	
	
	 
	
	
	
	
}

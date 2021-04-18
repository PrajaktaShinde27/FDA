package com.service;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.advices.CartIdNotExistException;
import com.model.Cart;
import com.model.Item;
import com.repository.CartRepository;

@Service
public class CartService {

	ItemService its;
	
	@Autowired(required=true)
	CartRepository cr;
	
	
	//Create Cart
	public Cart createCart(Cart c)
	{
		Cart c1=cr.save(c);
	
		return c1;
	}
	
	
	//Add items to cart
	public Cart addItemsToCart(Cart c) throws Exception
	{
		Supplier<Exception> s2 = ()->new CartIdNotExistException("Cart Id is not present in the database to add items");
		Cart c3=cr.findById(c.getCart_id()).orElseThrow(s2);
			c3.setCart_id(c.getCart_id());
			//c3.setItems(c.getItems());
			  List<Item> items=c3.getItems(); 
			  for(Item i:c.getItems()) 
			  {
				  items.add(i);
		  	} 
			//  System.out.println(items);
			  
			  c3.setItems(items);
			c3.setTotal_cost(calculateTotalCost(c3.getCart_id()));
			cr.save(c3);
		return c3;
	}

	
	//Delete Cart by cartId
	public String deleteCartById(int cid) throws Exception
	{
		Supplier<Exception> s2 = ()->new CartIdNotExistException("Cart Id is not present in the database to delete");
		Cart c2=cr.findById(cid).orElseThrow(s2);
		cr.deleteById(cid);
		return "Deleted";
	}
	
	
	//Remove all cart Items
	public String  deleteCartItems(int cid) throws Exception
	{
		Supplier<Exception> s2 = ()->new CartIdNotExistException("Cart Id is not present in the database to delete its items");
		Cart c2=cr.findById(cid).orElseThrow(s2);
		List<Item> list=c2.getItems();
		c2.getItems().clear();
		cr.save(c2);
		return "Deleted";
		
	}

	
	//Used in Customer Service to update cart
	
	  public Cart updateCartDetails(Cart c) throws Exception { 
	  Supplier<Exception>s2 = ()->new CartIdNotExistException("Cart Id is not present in the database to Update its details");
	  int cid=c.getCart_id(); Cart c3=cr.findById(cid).orElseThrow(s2);
	  c3.setCart_id(c.getCart_id()); 
	  c3.setTotal_cost(calculateTotalCost(c3.getCart_id()));
	 // c3.setItems(its.createItems(c.getItems())); 
	  
	  List<Item> items=c3.getItems(); 
	  for(Item i:c.getItems()) 
	  {
		  items.add(i);
  	} 
	//  System.out.println(items);
	  
	  c3.setItems(items);
	  cr.save(c3); 
	  return c3; 
	  }
	 
	  
	  
	  //Get Cart Details of particular cartId
	  
	public Cart getCartDetails(int cid) throws Exception
	{
		Supplier<Exception> s3 = ()->new CartIdNotExistException("Cart Id is not present in the database to Display or retieve");
		Cart c4=cr.findById(cid).orElseThrow(s3);
		return c4;
	}
	
	
	
	//Calculate TotalCost
	
	public int calculateTotalCost(int cartid) throws Exception
	{
     int  totalcost=0;
     Supplier<Exception>s2 = ()->new CartIdNotExistException("Cart Id is not present in the database to Update its details");
     Cart cart=cr.findById(cartid).orElseThrow(s2);
     List<Item>items=cart.getItems();
     for(Item i:cart.getItems())
     {
    	totalcost=totalcost+i.getCost();
     }
     System.out.println(totalcost);
     return totalcost;
	}
	
	
	
}

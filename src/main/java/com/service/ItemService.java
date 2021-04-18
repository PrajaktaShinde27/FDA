package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ItemNameNotFoundException;
import com.advices.ItemNotFoundException;
import com.advices.RestIdNotFoundException;
import com.model.Cart;
import com.model.Item;
import com.model.Restaurant;
import com.repository.CartRepository;
import com.repository.ItemRepository;
import com.repository.RestaurantRepository;

@Service
public class ItemService {

	List<Item> items;
	@Autowired(required=true)
	ItemRepository irepo;
	
	@Autowired(required=true)
	RestaurantRepository repo;
	
	@Autowired(required=true)
	CartRepository crepo;
	
	//get list of Item
	public List<Item> getListOfItems()
	{
		items=new ArrayList<>();
		
		items=irepo.findAll();
		
		return items;
	}
	
	//Get Item by its Id
	public Item getItemById(int itemId)
	{
		Item i1=irepo.findById(itemId).orElse(null);
		return i1;
	}
	
	
	//Create Item
	public Item createItem(Item i)
	{
		Item i1=irepo.save(i);
		return i1;
	}
	
	//create List of Item
	public List<Item> createItems(List<Item> i)
	{
		items=new ArrayList<>();
		items=irepo.saveAll(i);
		return items;
	}
	

	//Update Item
	@SuppressWarnings("unused")
	public Item updateItem(Item i) throws Exception
	{
		int id=i.getItemId();
		Supplier<Exception> s=()->new ItemNotFoundException("Item Id is not present in the database");
		Item i1=irepo.findById(id).orElseThrow(s);
	//	Supplier<Exception> s1=()->new ItemNameNotFoundException("Item name is not present in the database");
		//Item i2=irepo.findByitemName(i.getItemName()).orElseThrow(s1);
		i1.setItemId(i.getItemId());
		i1.setItemName(i.getItemName());
		i1.setCost(i.getCost());
		irepo.save(i1);
		return i1;
	}
	
	//Delete whole item
	@SuppressWarnings("unused")
	public String deleteItem(Item i) throws Exception
	{
		int id=i.getItemId();
		Supplier<Exception> s=()->new ItemNotFoundException("Item Id is not present in the database");
		Item i1=irepo.findById(id).orElseThrow(s);
		Supplier<Exception> s1=()->new ItemNameNotFoundException("Item Name is not present in the database");
		Item i2=irepo.findByitemName(i.getItemName()).orElseThrow(s1);
		irepo.delete(i);
		return "Deleted";
	}
	
	
	// DeleteItem By its ID
	@SuppressWarnings("unused")
	public String deleteItemById(int itemId)
	{
		Item i1=irepo.findById(itemId).orElse(null);
		irepo.deleteById(itemId);
		return "Deleted";
	}
	
	
	
}

	
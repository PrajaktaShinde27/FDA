package com.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Item;
import com.service.ItemService;



@RequestMapping("/api")
@RestController
public class ItemController {	
	@Autowired
	ItemService itemsservice;

	
	
   @GetMapping("/getItems")
	public ResponseEntity<List<Item>> getList()
	{
		List<Item> items=itemsservice.getListOfItems();
		ResponseEntity re=new ResponseEntity<List<Item>>(items,HttpStatus.OK);
		return re;
	}
   
   
   @GetMapping("/getItem/{itemId}")
	public ResponseEntity<Item> getListItemsById(@PathVariable int itemId)
	{
		Item items=itemsservice.getItemById(itemId);
		ResponseEntity re=new ResponseEntity<Item>(items,HttpStatus.OK);
		return re;
	}
   
   
	@PostMapping("/addItem/")
	public ResponseEntity<Item> addItem(@Valid  @RequestBody Item i)
	{
		Item i1=itemsservice.createItem(i);
		ResponseEntity re1=new ResponseEntity<Item>(i1,HttpStatus.OK);
		return re1;
	}
	
	
	@PostMapping("/addItems")
	public ResponseEntity<List<Item>> addItems(@Valid @RequestBody List<Item> i)
	{
		List<Item> i1=itemsservice.createItems(i);
		ResponseEntity re1=new ResponseEntity<List<Item>>(i1,HttpStatus.OK);
		return re1;
	}
	
	
	@PutMapping("/updateItem")
	public ResponseEntity<Item> updateItem(@RequestBody Item i) throws Exception
	{
		Item i1=itemsservice.updateItem(i);
		ResponseEntity re1=new ResponseEntity<Item>(i1,HttpStatus.OK);
		return re1;
	}
	
	
	
	@DeleteMapping("/deleteItem")
	public ResponseEntity<String> deleteItem(@RequestBody Item i) throws Exception
	{
		itemsservice.deleteItem(i);
		
		ResponseEntity re1=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re1;
	}
	
	
	@DeleteMapping("/deleteItem/{itemId}")
	public ResponseEntity<String> deleteItemById(@PathVariable int itemId)
	{
	
		itemsservice.deleteItemById(itemId);
		ResponseEntity re1=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re1;
	}
	
	
	
	
}


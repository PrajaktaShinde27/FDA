package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	//One cart has many items
	  @OneToMany(cascade=CascadeType.ALL)
	  @JoinColumn
	  private List<Item> items;
	  
	 
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int cart_id;
	private float total_cost;
	
	
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public float getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}
	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", total_cost=" + total_cost + "]";
	}
	
	
	
	

}

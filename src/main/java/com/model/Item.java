package com.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item {
	
	
	
	
	/*
	 * @ManyToOne(cascade=CascadeType.ALL) //@JoinColumn() private Cart cart;
	 * 
	 * 
	 * public Cart getCart() { return cart; } public void setCart(Cart cart) {
	 * this.cart = cart; }
	 */
	 
	  
	
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	
	@NotNull
	@Size(min=4,  message="Length of item name should be of minimum 4")
	private String itemName;
	
	@NotNull
	private int cost;
//	@NotNull
	//private int quantity;
	//public int getQuantity() {
		//return quantity;
	//}
	//public void setQuantity(int quantity) {
		//this.quantity = quantity;
	//}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", cost=" + cost + "]";
	}
	
	
}
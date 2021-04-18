package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Customer {

	@OneToOne(cascade=CascadeType.ALL)
	private Cart cart;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int customer_id;
	
	
	@NotNull
	@Size(min=2, message="Length of First name should be atleast 2")
	@Column
	String first_name;
	
	
	@NotNull
	@Size(min=2, message="Last Name must be of minimum length of 2")
	@Column
	String last_name;
	String gender;
	
	@NotNull
	@Size(min=2, message="Address must be of minimum length of 8")
	@Column
	String address;
	
	
	@NotNull
	@Pattern(regexp="^[6-9][0-9]{9}$", message="Please enter valid number")
	@Column
	String contact_number;
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", address=" + address + ", contact_number=" + contact_number + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

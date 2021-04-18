package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Payment {
	

	@ManyToOne(cascade=CascadeType.ALL)
	private Cart cart;
	

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payment_id;
	private String payment_mode;
	private float total_cost;
	private Date dt;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public float getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}
	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}
	
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", payment_mode=" + payment_mode + ", total_cost=" + total_cost
				+ ", dt=" + dt + "]";
	}

}

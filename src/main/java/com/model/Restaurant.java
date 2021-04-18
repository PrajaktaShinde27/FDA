package com.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rid;
	
	@NotNull
	@Size(min= 2, message="Restaurant name must be of length 2")
	private String rname;
	
	@NotNull
	@Size(min= 8, message="Restaurant Address must be of length 8")
	private String Address;
	@NotNull
	@Pattern(regexp="^[6-9][0-9]{9}$", message="Please enter valid number")
	private String contactNo;
	

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<Item> items;
	
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Restaurant [rid=" + rid + ", rname=" + rname + ", Address=" + Address + ", contactNo=" + contactNo
				+ "]";
	}
	
	
}

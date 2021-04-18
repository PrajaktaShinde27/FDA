package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CustomerLogin {
	
	@Override
	public String toString() {
		return "Login1 [name=" + name + ", pass=" + pass + "]";
	}
	@Id
	@Column(name = "NAME",unique=true, nullable = false)
	private String name;
	private String pass;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	 
	
	

}

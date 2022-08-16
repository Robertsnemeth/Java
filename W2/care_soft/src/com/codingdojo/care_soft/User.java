package com.codingdojo.care_soft;

public class User {
	protected Integer id;
	protected int pin;
	
	public User() {}
	
	public User(Integer idParam) {
		this.id = idParam;
	}
	
	public void setID(Integer idParam) {
		this.id = idParam;
	}
	
	public void setPin(int pinParam) {
		this.pin = pinParam;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public int getPin() {
		return this.pin;
	}
}

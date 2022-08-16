package com.codingdojo.care_soft;

public interface HIPAACompliantUser {
	
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);

}

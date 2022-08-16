package com.codingdojo.care_soft;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer idParam, String roleParam) {
    	super(idParam);
    	this.role = roleParam;
    	this.securityIncidents = new ArrayList<String>();
    }
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pinParam) {
    	int length = String.valueOf(pinParam).length();
    	if(length == 6) {
    		this.pin = pinParam;
    		return true;
    	}
    	else {
    		
    		return false;
    	}
    }
    
    @Override
    public boolean accessAuthorized(Integer idParam) {
    	if(this.id == idParam) {
    		return true;
    	} else {
    		return false;
    	}
    }
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	return this.securityIncidents;
    }

    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    public void setRole(String roleParam) {
    	this.role = roleParam;
    }
    
    public void addIncident(String incident) {
    	securityIncidents.add(incident);
    }
    
    public boolean getRole() {
    	System.out.println(this.role);
    	return true;
    }
    
    public boolean getIncidents() {
    	System.out.println(securityIncidents);
    	return true;
    }


}

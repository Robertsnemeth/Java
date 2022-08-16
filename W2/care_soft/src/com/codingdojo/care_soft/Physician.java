package com.codingdojo.care_soft;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer idParam) {
    	super(idParam);
    }
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pinParam) {
    	int length = String.valueOf(pinParam).length();
    	if(length == 4) {
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
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	
    // TO DO: Setters & Getters
    public void setPatientNotes(String notesParam) {
    	patientNotes.add(notesParam);
    }
    
    public boolean getPatientNotes() {
    	if(patientNotes.size() < 1) {
    		System.out.println(patientNotes);
    		return true;
    	} else {
    		System.out.println("There are no notes.");
    		return false;
    	}
    }

}

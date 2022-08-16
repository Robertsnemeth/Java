package com.codingdojo.zookeeper;

public class Gorilla extends Mammal{
	
	public void throwSomething() {
		System.out.println("The Gorilla has thrown something! He looks liked hes getting tuckered out.");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Ahhhh he must be enjoying that banana. His energy seems to be getting better.");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("There he goes, climbing that tree again.");
		this.energyLevel -= 10;
	}

}

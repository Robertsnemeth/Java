package com.codingdojo.zookeeper;

public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("That bat is taking off!");
		this.energyLevel -= 50;
		if(this.displayEnergy() < 0) {
			System.out.println("The monster is finally finished.");
		}
	}
	
	public void eatHumans() {
		System.out.println("Oh my god...RUN!");
		this.energyLevel += 25;
		if(this.displayEnergy() < 0) {
			System.out.println("The monster is finally finished.");
		}
	}
	
	public void attackTown() {
		System.out.println("Everything is destroyed....");
		this.energyLevel -= 100;
		if(this.displayEnergy() < 0) {
			System.out.println("The monster is finally finished.");
		}
	}

}

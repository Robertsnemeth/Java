package com.codingdojo.zookeeper;

public class Mammal {
	protected int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.printf("This mammal's energy level is at %d", this.energyLevel);
		System.out.println("\n");
		return this.energyLevel;
	}

}

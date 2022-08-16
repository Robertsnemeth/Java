package com.codingdojo.zookeeper;

public class MammalTest {

	public static void main(String[] args) {

		Mammal m = new Mammal();
		m.displayEnergy();
		
		Gorilla g = new Gorilla();
		g.displayEnergy();
		g.throwSomething();
		g.throwSomething();
		g.throwSomething();
		g.eatBananas();
		g.eatBananas();
		g.climb();
		g.displayEnergy();

		Bat b = new Bat();
		b.displayEnergy();
		b.attackTown();
		b.attackTown();
		b.attackTown();
		b.eatHumans();
		b.eatHumans();
		b.fly();
		b.fly();

		
		
		

	}

}

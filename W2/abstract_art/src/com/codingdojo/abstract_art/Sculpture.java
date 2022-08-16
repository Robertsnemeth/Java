package com.codingdojo.abstract_art;

public class Sculpture extends Art {
	protected String material;
	
	public Sculpture(String title, String author, String description, String material) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.material = material;
	}
	
	@Override
	public void viewArt() {
		System.out.println(this.title);
		System.out.println(this.author);
		System.out.println(this.description);
		System.out.println(this.material);
		System.out.println("\n");
	}

}

package com.codingdojo.abstract_art;

public class Painting extends Art {
	protected String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		this.title = title;
		this.author = author;
		this.description = description;
		this.paintType = paintType;
	}
	
	@Override
	public void viewArt() {
		System.out.println(this.title);
		System.out.println(this.author);
		System.out.println(this.description);
		System.out.println(this.paintType);
		System.out.println("\n");
	}

}

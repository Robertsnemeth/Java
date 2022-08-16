package com.codingdojo.abstract_art;

public abstract class Art {
	protected String title;
	protected String author;
	protected String description;
	
	protected Art() {}
	
	protected Art(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	public abstract void viewArt();

	
}

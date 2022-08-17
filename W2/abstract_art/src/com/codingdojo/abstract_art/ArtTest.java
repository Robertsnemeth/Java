package com.codingdojo.abstract_art;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArtTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Painting painting1 = new Painting("New Painting", "Me", "This is a test painting", "Oil");
		painting1.viewArt();
		Painting painting2 = new Painting("Starry Night", "Van Gogh", "The French Night Sky", "Acrylic");
		painting2.viewArt();
		Painting painting3 = new Painting("Mona Lisa", "Leo", "The most famous face in the world", "Oil");
		painting3.viewArt();
		
		Sculpture sculpture1 = new Sculpture("Test", "Me", "This is a test sculpture", "clay");
		sculpture1.viewArt();
		Sculpture sculpture2 = new Sculpture("David", "Old folx", "Famous Greek statue", "Marble");
		sculpture2.viewArt();
		Sculpture sculpture3 = new Sculpture("Ken Griffey Jr", "Seattle Mariners", "Pose of Griffey's swing", "Bronze");
		sculpture3.viewArt();
		
		ArrayList<Art> museum = new ArrayList<Art>();
		Random r = new Random();
		
		museum.add(painting1);
		museum.add(painting2);
		museum.add(painting3);
		museum.add(sculpture1);
		museum.add(sculpture2);
		museum.add(sculpture3);
		
		Collections.shuffle(museum);
		for(Art pieces : museum) {
			pieces.viewArt();
		}
			
		
		

		
		
		

	}

}

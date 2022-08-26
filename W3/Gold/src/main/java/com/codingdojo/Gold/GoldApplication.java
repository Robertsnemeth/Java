package com.codingdojo.Gold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoldApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoldApplication.class, args);
		
		int number = 123, reverse = 0;  
		System.out.println(number);
		while(number != 0)   
		{  
		int remainder = number % 10;  
		System.out.println(remainder);
		reverse = reverse * 10 + remainder; 
		System.out.println(reverse);
		number = number/10;  
		System.out.println(number);
		}  
		System.out.println("The reverse of the given number is: " + reverse); 
	}

}

package com.codingdojo.calculator;

public class CalcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		
		c.setOperandOne(10);
		c.setOperandTwo(2);
		c.setOperation("*");
		c.performOperation();
		c.setOperandOne(2);
		c.setOperandTwo(5);
		c.setOperation("+");
		c.performOperation();
		c.getResults();
		
	}

}

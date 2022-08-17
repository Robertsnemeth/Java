package com.codingdojo.calculator;

public class Calculator {
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double results;
	
	public Calculator() {}
	
	public void setOperandOne(double operand) {
		this.operandOne = operand;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public void setOperandTwo(double operand) {
		this.operandTwo = operand;
	}
	
	public void performOperation() {
		if(operation == "-") {
			this.results = (operandOne -= operandTwo + results);
		} else if(operation == "+") {
			this.results = (operandOne += operandTwo + results);
		} else if(operation == "*") {
			this.results = (operandOne * operandTwo + results);
		} else if(operation == "/") {
			this.results = (operandOne / operandTwo + results);
		} else {
			System.out.println("Please enter either '-' or '+'");
		}
	}
	
	public double getResults() {
		System.out.println(results);
		return results;
	}
	
	

}

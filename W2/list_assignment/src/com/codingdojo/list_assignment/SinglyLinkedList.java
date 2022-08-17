package com.codingdojo.list_assignment;

public class SinglyLinkedList {
	public Node head;
	
	public SinglyLinkedList() {
		this.head = null;
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			return;
		} 
		Node runner = head;
		while(runner.next != null) {
			runner = runner.next;
		}
		runner.next = newNode;
	}
	
	public Integer remove() {
		Node runner = head;
		int val;
		if(runner == null) {
			return null;
		} if(runner.next == null) {
			val = runner.value;
			runner = null;
			return val;
		}
		while(runner.next.next != null) {
			runner = runner.next;
		}
		val = runner.next.value;
		runner.next = null;
		return val;
	}
	
	public void printValues() {
		Node runner = head;
		if(runner == null) {
			System.out.println("This list is empty.");
		}
		while(runner.next != null) {
			System.out.println(runner.value);
			System.out.println(runner.next.value);
			runner.next = runner;
		}

		
		
	}

}

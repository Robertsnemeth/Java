package order_and_items;
import java.util.ArrayList;


public class Order {
	private String name;
	private boolean ready;
	private ArrayList<Item> items;
	
	
	public Order() {
		this.name = "Guest";
		this.items = new ArrayList<Item>();
	}
	
	public Order(String name) {
		this.name = name;
		this.items = new ArrayList<Item>();
		
	}
	
	public void setOrderStatus(boolean ready) {
		this.ready = ready;
	}
	
	public void setOrderName(String name) {
		this.name = name;
	}
	
	public void addOrderItems(Item drink) {
		this.items.add(drink);
	}
	
	public void getOrderStatus() {
		if(this.ready == true) {
			System.out.println( "Your order is ready!");
		} else {
			System.out.println( "Thank you for waiting. Your order will be ready soon.");
		}
	}
	
	public void getOrderTotal() {
		double total = 0;
		for(Item drink : this.items) {
			total += drink.getItemPrice();
		}
		System.out.printf("Your total is $%.2f", total);
	}
	
	public void display() {
		System.out.println("Customer Name: " + this.name);
		for(Item drink : this.items) {
			System.out.printf("%s -- $%.2f", drink.getItemName(), drink.getItemPrice());
			System.out.println("\n");
		}
	}
	
}

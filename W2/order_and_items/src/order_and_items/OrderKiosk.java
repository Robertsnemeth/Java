package order_and_items;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderKiosk {
	private static ArrayList<Item> menu;
	private static ArrayList<Order> orders;
	
	public OrderKiosk() {
		menu = new ArrayList<Item>();
		orders = new ArrayList<Order>();
	}
	
	public void addMenuItem(String name, double price) {
		Item drink = new Item(name, price);
		menu.add(drink);
		drink.setIndex(menu.indexOf(drink));
	}
	
	private static void displayMenu() {
		for(Item drink : menu) {
			System.out.printf("%d %s -- $%.2f", drink.getIndex(), drink.getItemName(), drink.getItemPrice());
			System.out.println("\n");
		}
	}
	
	public void newOrder() {
		System.out.println("Please enter customer name for new order:");
		String name;
		Scanner scanIn = new Scanner(System.in);
		name = scanIn.nextLine();
		System.out.println(name);
		OrderKiosk.displayMenu();
		System.out.println("Please enter a menu item index or q to quit");
		String itemNumber;
		itemNumber = scanIn.nextLine();
		double total = 0.00;
		while(!itemNumber.equals("q")) {
			Item drink = OrderKiosk.menu.get(Integer.parseInt(itemNumber));
			total += drink.getItemPrice();
			System.out.printf("%s $%.2f", drink.getItemName(), drink.getItemPrice());
			System.out.println("\n");
			itemNumber = scanIn.nextLine();
			}
		scanIn.close();
		System.out.println("Thank you " + name);
		System.out.printf("Your order total is $%.2f ", total);
	}
	

}

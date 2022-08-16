package order_and_items;

public class TestOrders {

	public static void main(String[] args) {
		
//		ORIGINAL CODE WITHOUT KIOSK
		
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order("Bobby");
		Order order4 = new Order("Hannah");
		Order order5 = new Order("Mugi");

		Item drip  = new Item("Drip", 1.50);
		Item latte  = new Item("Latte", 2.50);
		Item mocha  = new Item("Mocha", 3.50);
		Item capuccino  = new Item("Capuccino", 4.50);
		
		order3.addOrderItems(capuccino);
		order3.addOrderItems(mocha);
		
		order4.setOrderStatus(true);
		order5.setOrderStatus(true);
		
		
		order3.getOrderStatus();
		order4.getOrderStatus();
		order5.getOrderStatus();	
		
		order3.getOrderTotal();
		
		order1.display();
		order2.display();
		order3.display();
		order4.display();
		order5.display();
		
//		ORDER KIOSK TESTS
		
		OrderKiosk kiosk = new OrderKiosk();
		
		kiosk.addMenuItem("Drip", 1.50);
		kiosk.addMenuItem("Latte", 2.50);
		kiosk.addMenuItem("Mocha", 3.50);
		kiosk.addMenuItem("Capuccino", 4.50);
		
		kiosk.newOrder();

		
		

		
		
	}

}

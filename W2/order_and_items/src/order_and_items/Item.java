package order_and_items;

public class Item {
	private String itemName;
	private double price;
	private int index;
	
	public Item() {};
	
	public Item(String name, double price) {
		this.itemName = name;
		this.price = price;
	}
	
	public void setIndex(int arrayIndex) {
		this.index = arrayIndex;
	}
	
	public void setItemName(String name) {
		this.itemName = name;
	}
	
	public void SetItemPrice(double price) {
		this.price = price;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getItemPrice() {
		return price;
	}

	public int getIndex() {
		return index;
	}
}

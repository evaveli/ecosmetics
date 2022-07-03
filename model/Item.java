package model;

public class Item implements Calculations{

	private String name;
	private int quantity;
	private double price;
	
	public Item(String name, int quantity, double price) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}


	public double calculateTotalIncome(int quantity, double price) {
		double income = quantity*price;
		return income;
	}

	
	
	
	
}

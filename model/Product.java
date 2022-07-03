package model;

import java.io.Serializable;

public class Product implements Serializable{
	private String barcode;
	private String name;
	private String category;
	private String supplier;

	private int stock;	
	
	public Product(String barcode, String name,  int stock) {
		this.stock = stock;
		this.barcode = barcode;
		this.name = name;
	}

	public Product(String barcode, String name, String category, String supplier) {
		stock=0;
		this.barcode = barcode;
		this.name = name;
		this.category = category;
		this.supplier = supplier;
		
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}


	public String getBarcode() {
		return barcode;
	}
	
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", name=" + name + ", category=" + category + ", supplier=" + supplier
				+ ", stock=" + stock + "]";
	}





}

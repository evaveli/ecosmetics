package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SoldProduct implements Serializable{
	
	private String name;
	private String barcode;
    private int quantity;
    private double price;
    private THEDate Date;
    
	public SoldProduct(String barcode,String name, int quantity, double sprice) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		THEDate Date = new THEDate(sdf.format(new Date()));
		this.barcode = barcode;
		this.name=name;
		this.quantity = quantity;
		this.price = price;
		this.Date = Date;
	}
	

	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBarcode() {
		return barcode;
	}



	public void setBarcode(String barcode) {
		this.barcode = barcode;
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



	public THEDate getDate() {
		return Date;
	}



	public void setDate(THEDate date) {
		Date = date;
	}



	@Override
	public String toString() {
		return "SoldProduct [barcode=" + barcode + ", name=" + name + ", quantity=" + quantity + ", sellprice="
				+ price + ", sellDate=" + Date + "]";
	}

	
	

    
}

package model;

import java.io.Serializable;

public class PurchasedProduct implements Serializable{
	private String barcode; 
    private int quantity;
    private THEDate boughtDate;
    private THEDate expiryDate;
	public PurchasedProduct(String barcode, int quantity, THEDate boughtDate) {
		super();
		this.barcode = barcode;
		this.quantity = quantity;
		this.boughtDate = boughtDate;
		
	}

	public String getBarcode() {
		return barcode;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public THEDate getBoughtDate() {
		return boughtDate;
	}
	public THEDate getExpiryDate() {
		return expiryDate;
	}	
	@Override
	public String toString() {
		return "PurchasedProduct [barcode=" + barcode + ", quantity=" + quantity 
				+ ", purchasedDate=" + boughtDate + ", expiryDate=" + expiryDate + "]";
	}
    
}

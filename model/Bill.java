package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Bill {

	    private static int billNumber=0;
	    private String billName;
	    String supplier;
	    private LocalDate billDate;
	    private double price;
	    int quantitySold;

		public Bill(String cashierUsername, String supplier, LocalDate billDate, double total, int quantity) {
			this.billName = cashierUsername;
			this.billDate = billDate;
			this.price = total;
			this.supplier = supplier;
			quantitySold = quantity;
			++billNumber;
		}
		
		public static int getBillNo() {
			return billNumber;
		}
		
		public String getCashierUsername() {
			return billName;
		}
		
		public LocalDate getBillDate() {
			return billDate;
		}
		
		public double getTotal() {
			return price;
		}
		
		@Override
		public String toString() {
			return "Bill \n"+"billName=" + billName + "\n supplier=" + supplier + "\n billDate=" + billDate + "\n price="
					+ price + "\n quantitySold=" + quantitySold+"\n\n";
		}
}

//package model;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//
//public class Bill implements Serializable{
//    private static int billNo=0;
//    private String cashierUsername;
//    private MyDate billDate;
//    private double total;
//    private ArrayList<SoldProduct> soldProducts;
//    
//	public Bill(String cashierUsername, MyDate billDate, double total,ArrayList<SoldProduct> soldProducts) {
//		this.cashierUsername = cashierUsername;
//		this.billDate = billDate;
//		this.total = total;
//		this.soldProducts=soldProducts;
//		billNo++;
//	}
//	public static int getBillNo() {
//		return billNo;
//	}
//	public String getCashierUsername() {
//		return cashierUsername;
//	}
//	public MyDate getBillDate() {
//		return billDate;
//	}
//	public double getTotal() {
//		return total;
//	}
//	public ArrayList<SoldProduct> getSoldProducts() {
//		return soldProducts;
//	}
//    
//    
//}

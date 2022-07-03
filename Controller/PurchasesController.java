package Controller;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Controller.ProductController;
import model.THEDate;
import model.PurchasedProduct;
import model.SoldProduct;

public class PurchasesController {
    
	private static final String soldfile="sold.bin";
	private static final String purchasedfile = "purchase.bin";
	private File soldfilename;
	private File purchasefilename;
	ArrayList<SoldProduct> soldTable;
    ArrayList<PurchasedProduct> purchasedTable;
	
    public PurchasesController() {
		soldTable=new ArrayList<>();
		purchasedTable=new ArrayList<>();
		soldfilename=new File(soldfile);
		purchasefilename= new File(purchasedfile);
		if(soldfilename.exists()) {
			readSoldProducts();
		} else {
			writeSoldProducts();
		}
		if(purchasefilename.exists()) {
			readPurchasedProducts();
		} else {
			writePurchasedProducts();
		}
	}
   
    public ArrayList<SoldProduct> getSoldTable() {
		return soldTable;
	}

	public ArrayList<PurchasedProduct> getPurchasedTable() {
		return purchasedTable;
	}
	
	private void writeSoldProducts() {
		try {
			FileOutputStream fos=new FileOutputStream(soldfilename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(soldTable);
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		}
	}
	
	private void readSoldProducts() {
		try {
			FileInputStream fis=new FileInputStream(soldfilename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			soldTable=(ArrayList<SoldProduct>)
			ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		}
	}
	
	private void writePurchasedProducts() {
		try {
			FileOutputStream fos=new FileOutputStream(purchasefilename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(purchasedTable);
			oos.close();fos.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		} 
		}
	
	private void readPurchasedProducts() {
		try {
			FileInputStream fis=new FileInputStream(purchasefilename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			purchasedTable=(ArrayList<PurchasedProduct>)
			ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be careful!");
		}
	}
	
	public void addPProduct(int position, String barcode, int quantity) {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		THEDate purchasedDate = new THEDate(sdf.format(new Date()));
		purchasedTable.add(new PurchasedProduct(barcode, quantity, purchasedDate));
		ProductController pc = new ProductController();
		pc.addQuantity(position,quantity);
		writePurchasedProducts();
	}

}

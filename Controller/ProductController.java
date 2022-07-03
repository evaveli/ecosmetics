package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import model.Product;


public class ProductController {
	
	private ArrayList<Product> products;
	private static final String file="product.bin";
	private File filename;
	
	public ProductController() {
		products=new ArrayList<>();
		filename=new File(file);
		if(filename.exists()) {
			readProducts();
		} else {
			writeProducts();
		}
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		products.add(product);
		writeProducts();
	}
	
	private void writeProducts() {
		try {
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(products);
			oos.close();fos.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		}
	}
	
	private void readProducts() {
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			products=(ArrayList<Product>)
			ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			System.err.println("Be Careful!");
		} 
	}
	
	public boolean useBarcode(String barcode) {
		for(Product p : products) {
			if((p.getBarcode()).equals(barcode)) {
				return true;
			}
		}			
		return false;
	}
	

	public int getPosition(Product prod) {
		
		for(int i=0; i<products.size(); i++)	{
			if(products.get(i).getBarcode()==prod.getBarcode())
				return i;	}	
		return -1;
	}
	
	
	
	public void deleteProduct(Product product) {
	   products.remove(product);
		writeProducts();
	}
	
	
	
	
	public void addQuantity(int pos, int quantity) {
		products.get(pos).setStock(products.get(pos).getStock()+quantity);
		writeProducts();
	}


}

package Controller;

import java.io.File;
import java.util.ArrayList;

import model.Item;
import model.Manager;


public class ManagerController {

	private ArrayList<Manager> manager;
	private ArrayList<Item> item;
	private ArrayList<CashierController> cashierController;
	private int nrItems=0;
	File file;
	
	public ManagerController() {
		manager = new ArrayList<Manager>();
	}

	public ArrayList<Manager> getManager() {
		return manager;
	}

	public void setManager(ArrayList<Manager> manager) {
		this.manager = manager;
	}
	
	public int getNrItems() {
		return this.nrItems;
	}
	
	public void setNrItems(int nr) {
		nrItems = nr;
	}
	
	public void addItem(Item i) {
		item.add(i);
		nrItems++;
	}
	
	public String checkCashierPerformance(CashierController c) {
	  
		if(c.getNrBills()>=5)
		  return "OK";
		else return "FAIL";
	}
	
}

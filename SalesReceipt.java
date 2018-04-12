package Project3;
//Omar Sultani
//Project 2 Inventory System
//Stein
//2/27/16



public class SalesReceipt  {

	
//Initializing different variables

	private int SaleID;
	private String saleItems;
	private int customerID;
	private int dateTime;
	private double totalRev;
	
//Creating constructor for the class
	public SalesReceipt(int SaleID, int customerID){
		this.customerID = customerID;
		this.SaleID = SaleID;
	
	}
	
//Different methods to be used
	public int getSaleID() {
		return SaleID;
	}

	public void setSaleID(int SaleID) {
		this.SaleID = SaleID;
	}
	public void addSaleID(int SaleID) {
		this.SaleID+=1;
	}

	public int getcustomerID() {
		return customerID;
	}

	public void setcustomerID(int customerID) {
		this.customerID += 1;
	}
	
	public String getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(String saleItems) {
		this.saleItems = saleItems;
	}
	public int getDateTime() {
		return dateTime;
	}
	public void setDateTime(int dateTime) {
		this.dateTime = dateTime;
	}
	public double getTotalRev() {
		return totalRev;
	}
	public void setTotalRev(double totalRev) {
		this.totalRev = totalRev;
	}




}

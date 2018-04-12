package Project3;
//Omar Sultani
//Project 2 Inventory System
//Stein
//2/27/16



public class SalesItems implements Comparable<SalesItems>{

//Initializing different variables
	private int ID;
	private int customerId;
	private String unitPrice;
	private int units;
	private String description;



//Constructor that is being used for the class
	public SalesItems(int customerId, int ID, int units)
	{
		this.ID = ID;
		this.customerId= customerId;
		this.units = units;
	}
	
//Different methods that will be used
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		
		
		this.ID = iD;
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getUnits() {
		return units;
	}
	

	public void setUnits(int units) {
		this.units = units;
	}
	public void addUnits(int units){
	this.units += units;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

//Override and toString method below along with compareTo of SalesItems
	@Override
	public int compareTo(SalesItems s){
		if (this.getID() > s.getID()){
			return 1;
		} else if (this.getID() < s.getID()){
			return -1;
		} else {
			return 0;
		}
	}
	@Override
	
	public String toString(){
		return ID +"       " +  unitPrice  +  "       " +units;
	}


}

package Project3;
//Omar Sultani
//Project 2 Inventory System
//Stein
//2/27/16


public class Product
{
// Initializing variables
  private int ID;
	private String description;
	private  String price;
	
//Creating constructor for the class
	public Product(int ID, String description, String price)
	{
		this.ID = ID;
		this.description = description;
		this.price = price;
	}
	
//Various types of methods
	public int getID()
	{
		return ID;
	}

	public void setID(int ID)
	{
		this.ID=ID;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getPrice()
	{
		return price;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}
	
}
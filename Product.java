//Omar Sultani
//Project 4 Extra Credit
//Stein 

package Project4;
public class Product {
    

    private int productID;
    private String description;
    private double price;
    public Product(int productID, String description, double price){
        this.productID = productID;
        this.description = description;
        this.price = price;
    }
    

    public int getProductID(){
        return productID;
    }
    public void setProductID(int id){
        productID = id;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String d){
        description = d;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double p){
        price = p;
    }
 

    public String toString(){
        return "ID: " + productID + "\tPrice: " + "$" + price 
                + "\tDescription: " + description;
    }


	public Object getId() {
		return null;
	}
    
}
//Omar Sultani
//Project 4 Extra Credit
//Stein 

package Project4;
public class SaleItems {
   private int productID;
   private int unitPrice;
   private int units;
public SaleItems(int productID, int unitPrice, int units){
   this.productID = productID;
   this.unitPrice = unitPrice;
   this.units = units;
}
public int getProductID(){
        return productID;
    }
    public void setProductID(int p){
        productID = p;
    }
    public int getUnitPrice(){
        return unitPrice;
    }
    public void setUnitPrice(int up){
        unitPrice = up;
    }
    public int getUnits(){
        return units;
    }
    public void setUnits(int u){
        units = u;
    }
    
    public String toString(){
        return "ID: " + productID + "\tUnits: " + "$" + units 
                + "\tUnitPrice: " + unitPrice;
    }
	public void addUnitsSold(int units2) {
		// TODO Auto-generated method stub
		
	}
    
}
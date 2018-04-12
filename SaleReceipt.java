//Omar Sultani
//Project 4 Extra Credit
//Stein 

package Project4;
import java.sql.Date;
import java.util.ArrayList;

public class SaleReceipt {
   private int saleID;
   private int customerID;
   private Date dateANDtime;
   @SuppressWarnings("unchecked")
private ArrayList <SaleItems> saleItemList = new ArrayList();
public SaleReceipt(int IDID){
   setCustomerID(IDID);
   setSaleID();
   dateANDtime = new Date(IDID);
}
public void setSaleID() {
   if (saleID == 0) {
   
   }
}

public int getSaleID() {
   return saleID;
}
public void setCustomerID(int CID) {
   if (CID == 0) {
      customerID = CID;
   }
}

public int getCustomerID() {
   return customerID;
}
public void setTimeAndDate() {
   if (dateANDtime == null) {
      dateANDtime = new Date(customerID);
   }
}

public boolean hasItem(int i) {
    for (SaleItems SaleItem : saleItemList) {
      if (SaleItem.getProductID() == i) {
        return true;
      }
    }
    return false;
}
  
public SaleItems getSaleItem(int i) {
    for (SaleItems SaleItem : saleItemList) {
      if (SaleItem.getProductID() == i) {
        return SaleItem;
      }
    }
    
    return null;
}
  
public void addSaleItem(SaleItems item) {
    if(hasItem(item.getProductID())) {
      SaleItems olderItem = getSaleItem(item.getProductID());
      olderItem.addUnitsSold(item.getUnits());
    }

    else {
      saleItemList.add(item);
    }
  }
  
  public String getReceipt() {
    String receipt = "";
    for(SaleItems SaleItem : saleItemList){
      receipt += SaleItem.toString();
    }
    return receipt;
  }
  
  public String toString() {
    String dateTime = null;
	return "Sale ID:" + saleID + "\nCustomer ID: " + customerID + "\nDate: " 
      + dateTime + "\n\n" + getReceipt() + "\n";
  }
}
//Omar Sultani
//Project 4 Extra Credit
//Stein 


package Project4;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class InventorySystem {

	LinkedList<Product> productList = new LinkedList<Product>();
	LinkedList<SaleItems> salesList = new LinkedList<SaleItems>();
	LinkedList<InventorySystem> inventoryList = new LinkedList<InventorySystem>();

	public static void main(String[] args) throws IOException {

		InventorySystem obj = new InventorySystem();

		obj.readFiles();
		obj.dataMove();
		obj.inventory();
		obj.printInventoryList();
		obj.sort(obj.salesList);
		obj.printSalesReceipt();
		obj.addING();
		obj.totalRevenue();
		obj.selectionSort1(obj.salesList);
		obj.totalRevenue();
	}


private void selectionSort1(LinkedList<SaleItems> salesList2) {
		// TODO Auto-generated method stub
		
	}


public void readFiles() throws IOException {
	BufferedReader br1 = null;
	BufferedReader br2 = null;
	BufferedReader br3 = null;

	String line = "";
	try {
		br1 = new BufferedReader(
				new FileReader("C:/Users/sulom/Documents/Comp 182 Java Projects/Project 2/Product Data.csv"));
		br2 = new BufferedReader(
				new FileReader("C:/Users/sulom/Documents/Comp 182 Java Projects/Project 2/Sales Data.csv"));
		br3 = new BufferedReader(
				new FileReader("C:/Users/sulom/Documents/Comp 182 Java Projects/Project 3/Inventory Data.csv"));
		br1.readLine();
		br2.readLine();
		br3.readLine();
		System.out.println("Product Id"+ "Description" + "Units Price");
		while ((line = br1.readLine()) != null) {
			String[] products = line.split(",");
			System.out.printf( products[0], products[1], products[2]);
			Product dataObject = new Product(Integer.parseInt(products[0]), products[1], products[2]);
			productList.add(dataObject);
		}
		System.out.println("Customer ID" + "Product ID" + "Units");

		while ((line = br2.readLine()) != null) {
			String[] sales = line.split(",");
			SaleItems dataObject = new SaleItems(Integer.parseInt(sales[0]), Integer.parseInt(sales[1]),
					Integer.parseInt(sales[2]));
			System.out.printf(sales[0], sales[1], sales[2]);

			salesList.add(dataObject);
		}
		System.out.println();
		System.out.println("Product ID" + "Starting Units");
		while ((line = br3.readLine()) != null) {
			String[] startingInventory = line.split(",");
			InventorySystem dataObject = new Inventory(Integer.parseInt(startingInventory[0]),Double.parseDouble(startingInventory[1]), Double.parseDouble(startingInventory[1]));
			System.out.printf(startingInventory[0], startingInventory[1]);
			inventoryList.add(dataObject);
		}

		Collections.sort(salesList);
	} finally {
		if (br1 != null) {
			br1.close();
		}
		if (br2 != null) {
			br2.close();
		}
		if (br3 != null) {
			br3.close();
		}
	}
}


public void dataMove() {
	Product Pa;
	SaleItems Pb;
	int current = 0;

	for (int i = 0; i < salesList.size(); i++) {
		Pa = productList.get(current);
		Pb = salesList.get(i);
		if (Pa.getId() == Pb.getProductID()) {
			Pb.setDescription(Pa.getDescription());
			Pb.setUnitPrice(Pa.getPrice());
		} else {
			current += 1;
			i--;
		}
	}
}

public void inventory() {
	SaleItems Pa;
	Inventory Pb;
	int current = 0;
	System.out.println( "Customer ID" + "Product Id" + "Description" + "Units");

	for (int i = 0; i < salesList.size(); i++) {
		Pa = salesList.get(i);
		Pb = inventoryList.get(current);
		if (Pa.getProductId() == Pb.getProductId()) {
			if (Pb.getEndingUnits() == 0) {
				System.out.printf(Pa.getCustomerId(), Pa.getProductId(),Pa.getDescription(), (int) Pa.getUnits());
				Pa.setUnits((int) Pb.getEndingUnits());
			} 

			else {
				if (Pa.getUnits() > Pb.getEndingUnits()) {
					Pb.setNeedUnits(Pa.getUnits() - Pb.getEndingUnits());
					System.out.printf(Pa.getCustomerId(), Pa.getProductId(),
							Pa.getDescription(), (int) Pb.getNeedUnits());

					Pa.setUnits((int) Pb.getEndingUnits());
					i--;

				} 
				else {
					Pb.setEndingUnits(Pb.getEndingUnits() - Pa.getUnits());
				}
			}
		} else {
			current += 1;
			i--;
		}
	}
}

public void printInventoryList() {
	System.out.println();
	System.out.println("Product ID" + "Starting Inventory"+ "Units Remaining"+ "Units Sold");
	for (int i = 0; i < inventoryList.size(); i++) {
		System.out.printf((int) inventoryList.get(i).getProductId(),
				(int) inventoryList.get(i).getStartingUnits(), (int) inventoryList.get(i).getEndingUnits(),
				(int) inventoryList.get(i).getCountUnits());
	}
}

public void sort(LinkedList<SaleItems> salesList) {
	for (int i = 0; i < salesList.size() - 1; i++) {
		for (int j = i + 1; j < salesList.size(); j++) {
			if (salesList.get(i).getCustomerId() > salesList.get(j).getCustomerId()) {
				SaleItems temp = salesList.get(j);
				salesList.set(j, salesList.get(i));
				salesList.set(i, temp);
			}
		}
	}
}

public void printSalesReceipt() {
	Date myDate = new Date(System.currentTimeMillis());
	SalesReceipt dataObject = new SalesReceipt(1, 1, myDate);
	SaleItems Pa, Pb;
	for (int i = 0; i < salesList.size(); i++) {
		if (i == 0) {
			Pa = salesList.get(i);
			Pa.setTotalPrice(Pa.getUnits() * Double.parseDouble(Pa.getUnitPrice().substring(1)));

			System.out.println("Sales Receipt: ");
			System.out.println("Sale ID: " + dataObject.getSaleId() + " Date-Time " + dataObject.getDate());
			System.out.printf("Customer ID", "Product ID", "Description","Units", "Units Price", "Total Price");
			System.out.printf(Pa.getCustomerId(), Pa.getProductId(),
					Pa.getDescription(), Pa.getUnits(), Pa.getUnitPrice(), Pa.getTotalPrice());
			dataObject.setReceiptTotal(Pa.getTotalPrice());
		} 
		else {
			Pa = salesList.get(i - 1);
			Pb = salesList.get(i);
			if (Pa.getCustomerId() == Pb.getCustomerId()) {
				Pb.setTotalPrice(Pb.getUnits() * Double.parseDouble(Pb.getUnitPrice().substring(1)));
				System.out.printf(Pb.getCustomerId(), Pb.getProductId(),
						Pb.getDescription(), Pb.getUnits(), Pb.getUnitPrice(), Pb.getTotalPrice());
				dataObject.setReceiptTotal(Pb.getTotalPrice() + dataObject.getReceiptTotal());
			} else {
				Pb.setTotalPrice(Pb.getUnits() * Double.parseDouble(Pb.getUnitPrice().substring(1)));
				System.out.println("Total Price: ", + dataObject.getReceiptTotal());
				dataObject.addSaleId(dataObject.getSaleId());
				System.out.println("Sale ID: " + dataObject.getSaleId() + " Date/Time " + dataObject.getDate());
				System.out.println("customerId"+ "Product Id"+ "Description"+"Units"+ "Units Price"+ "Total Price");
				System.out.printf(Pb.getCustomerId(), Pb.getProductId(),Pb.getDescription(), Pb.getUnits(), Pb.getUnitPrice(), Pb.getTotalPrice());
			}
		}
	}
	System.out.println();
}

private void addING() {
	SaleItems Pa, Pb;
	int current = 0;
	int size = salesList.size();
	for (int i = 0; i < size; i++) {
		if (i == 0) {
			current++;
		} else {
			Pa = salesList.get(current - 1);
			Pb = salesList.get(current);
			if (Pa.getProductId() == Pb.getProductId()) {
				Pa.addUnit(Pb.getUnits());
				Pa.setTotalPrice(Pb.getTotalPrice());
				salesList.remove(current);
			} else {
				current++;
			}
		}
	}
	Collections.sort(salesList);

}

public void totalRevenue() {
	System.out.println("List of products sold:");
	System.out.println("Product Id" + "Description" + "Units Price " +  "Units " + "Total Revenue");

	for (int i = 0; i < salesList.size(); i++) {
		if (i == 0) {
			salesList.get(i).setTotalPrice(
					salesList.get(i).getUnits() * Double.parseDouble(salesList.get(i).getUnitPrice().substring(1)));
			System.out.printf(salesList.get(i).getProductId(),salesList.get(i).getDescription(), salesList.get(i).getUnitPrice(), salesList.get(i).getUnits(),
					salesList.get(i).getTotalPrice());
		} 
		else {
			salesList.get(i).setTotalPrice(salesList.get(i).getUnits() * Double.parseDouble(salesList.get(i).getUnitPrice().substring(1)));
			System.out.printf(salesList.get(i).getProductId(),salesList.get(i).getDescription(), salesList.get(i).getUnitPrice(), salesList.get(i).getUnits(),
					salesList.get(i).getTotalPrice());
		}
	}
}

}
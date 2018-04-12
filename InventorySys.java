//Omar Sultani
//Project 2 Inventory System
//Stein
//2/27/16

package Project2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//Create a class called Inventory System, I used InventorySys
public class InventorySys {

	ArrayList<Product> productItems = new ArrayList<Product>();
	ArrayList<SalesItems> salesItems = new ArrayList<SalesItems>();


//Creating my main
	public static void main(String[] args) throws IOException {
		
//Different objects to ease the use of order of methods
		InventorySys obj = new InventorySys();
		obj.readFiles();
		obj.addUnitPrice();
		obj.selectionSort(obj.salesItems);
		obj.receipt();
		obj.noDuplicates();



	}
//Reading CSV files method
	public void readFiles() throws IOException {
		String productFile = "C:/Users/sulom/Documents/Comp 182 Java Projects/Project 2/Product Data.csv";
		String salesFile = "C:/Users/sulom/Documents/Comp 182 Java Projects/Project 2/Sales Data.csv";

		BufferedReader br2 = null;
		BufferedReader br = null;

		String line = "";

		try {
			br = new BufferedReader(new FileReader(productFile));
			br2 = new BufferedReader(new FileReader(salesFile));
			br.readLine();
			br2.readLine();
			System.out.println("ProductID   Description   Unit Price");
			
//While loop for continously reading file 1 until there isn't anything to be read.
			while ((line = br.readLine()) != null) {
				String[] product = line.split(",");
				if (product.length > 0) {
					Product data = new Product(Integer.parseInt(product[0]), product[1], product[2]);
					System.out.println(product[0] + "   " + product[1] + "  " + product[2]);
					productItems.add(data);
				}
			}
			System.out.println("\nID     ProductID    Units");

//While loop for continously reading file 2 until there isn't anything to be read.
			while ((line = br2.readLine()) != null) {

				String[] sales = line.split(",");
				SalesItems data = new SalesItems(Integer.parseInt(sales[0]), Integer.parseInt(sales[1]),
						Integer.parseInt(sales[2]));
				System.out.println(sales[0] + "        " + sales[1] + "        " + sales[2]);
				salesItems.add(data);

			}

			Collections.sort(salesItems);

		} finally {
			if (br != null) {

				br.close();
			}
			if (br2 != null) {

				br2.close();

			}
		}
	}

//Adding UnitPrice method
	public void addUnitPrice() {
		int count = 0;

		for (int i = 0; i < salesItems.size(); i++) {
			Product Pua = productItems.get(count);
			SalesItems Pub = salesItems.get(i);
			if (Pua.getID() == Pub.getID()) {
				Pub.setUnitPrice(Pua.getPrice());
				Pub.setDescription(Pua.getDescription());


			} else {
				count++;
				i--;
			}

		}System.out.println("\nProductID   Unit Price   Units");

		for(SalesItems s : salesItems){
			System.out.println(s);
		}

	}
//Writing and implementing a selection sort method
	public void selectionSort(ArrayList<SalesItems> salesItems) {
		for (int i = 0; i < salesItems.size() - 1; i++) {
			for (int j = i + 1; j < salesItems.size(); j++) {
				if (salesItems.get(i).getCustomerId() > salesItems.get(j).getCustomerId()) {
					SalesItems temp = salesItems.get(j);
					salesItems.set(j, salesItems.get(i));
					salesItems.set(i, temp);
				}
			}
		}
	}

//Receipt method calling
	public void receipt(){
		SalesReceipt data = new SalesReceipt(1,1);
		
		for(int i = 0 ; i<salesItems.size(); i++){
			if(i==0){
				SalesItems Pua = salesItems.get(i);
				
				System.out.println("\nSale ID: " + data.getSaleID() + "    Date: 2/27/16 - Time 12:00PM");
				System.out.println(data.getcustomerID() + "    "+Pua.getID() + "    "+Pua.getDescription() + "  "+Pua.getUnitPrice() +"   "+ Pua.getUnits());
			}
			else { 
				SalesItems Pua = salesItems.get(i-1);
				SalesItems Pub = salesItems.get(i);
				if(Pua.getCustomerId()== Pub.getCustomerId()){
					System.out.println(Pub.getCustomerId() + "    " +Pub.getID() +"    "+ Pub.getDescription() + "    "+Pub.getUnitPrice() + "    " +Pub.getUnits());


				}
				else{
					
					data.addSaleID(data.getSaleID());
					System.out.println("\nSale ID: "+ data.getSaleID() + "    Date: 2/27/16 - Time 12:00PM");
					//print titles   Customer ID Product ID Description UnitPrice Units
					System.out.println(Pub.getCustomerId()+"    "+Pub.getID() + "    "+Pub.getDescription() + "    "+Pub.getUnitPrice() +"  " +Pub.getUnits());
				}
			}



		}
		Collections.sort(salesItems);
	}

//Elimination of duplicates method
	public void noDuplicates() {
		int count = 0;
		int listSize= salesItems.size();

		for (int i = 0; i < listSize; i++) {
			if(i ==0){
				count++;
			}else{
				SalesItems Pua = salesItems.get(count-1);
				SalesItems Pub = salesItems.get(count);
				if (Pua.getID() == Pub.getID()) {
					Pua.addUnits(Pub.getUnits());
					salesItems.remove(count);

				} else {
					count++;

				}

			}
		}
		
//Printing out product id, unit price and units
		System.out.println("\nProductID Unit Price   Units");
		for(SalesItems s : salesItems){
			System.out.println(s);
		}
	}
}




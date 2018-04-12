//Omar Sultani
//Project 6
//Stein

package Project6;
import java.util.*;
import java.io.*;

public class BankSimulation{
 
	int customerCount = 0;
	Queue<Customer> queue = new LinkedList<Customer>();
	HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
	LinkedList<Customer> customerList = new LinkedList<Customer>();


	public static void main(String[]args){

		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s \n","Customer ID "," Arrival Time "," Waiting Time "," At Teller ","Transaction Time"," Departed");
		BankSimulation run = new BankSimulation();

		run.readTransactionType();
		run.readCustomers();
		run.checkCheck();
	}

	public void readTransactionType(){

		String filename="/Users/sulom/Documents/Comp 182 Java Projects/Project 6/TransactionType.csv";
		String line="";
		String csvSplit=",";
		String Description;
		int Time;
		BufferedReader br= null;

		try{
			br= new BufferedReader(new FileReader(filename));
			br.readLine();

			while((line=br.readLine())!=null){
				StringTokenizer na=new StringTokenizer(line,csvSplit);
				na.nextToken();
				Description=na.nextToken().trim().toString();
				Time=Integer.parseInt(na.nextToken().trim().toString());

				hashMap.put(Description,Time);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally{
			if(br!=null){
				try{
					br.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}


	public void readCustomers(){

		String filename="/Users/sulom/Documents/Comp 182 Java Projects/Project 6/Customer.csv";
		BufferedReader br= null;
		String line="";
		String csvSplit=",";

		@SuppressWarnings("unused")
		int ID=0;
		int customerID;
		int arrtime=0;
		String Customer;

		try{
			br= new BufferedReader(new FileReader(filename));
			br.readLine();

			int currentID = 0;
			Customer c = null;
			@SuppressWarnings("unused")
			int total = 0;

			while((line=br.readLine())!=null){
				String[]chart=line.split(csvSplit);
				ID=Integer.parseInt(chart[0]);
				customerID=Integer.parseInt(chart[1]);
				if(!chart[2].equals(""))
				{
					arrtime=Integer.parseInt(chart[2]);
				}
				Customer=chart[3];
				if(customerID!=currentID)
				{
					c = new Customer(customerID,arrtime);
					customerList.add(c);
					customerCount++;
				}
				c.AddTransaction(hashMap.get(Customer));
				currentID=customerID;
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
			{
				try
				{
					br.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}


	public int getTransactionTime(Customer c){
		int sum=0;
		for(int i=0;i<c.transactionList.size();i++){
			sum+=c.transactionList.get(i);
		}
		return sum;
	}


	public Customer getCustomer(int arrtime){
		for(int i=0;i<customerList.size();i++){
			if(customerList.get(i).arrivalTime==arrtime){
				Customer c=customerList.get(i);
				customerList.remove(i);
				return c;
			}
		}
		return null;
	}
	public boolean customerDeparture(int time){
		for(int i=0;i<customerList.size();i++){
			if(customerList.get(i).arrivalTime==time){
				return true;
			}
		}
		return false;
	}
	public void checkCheck(){
		int time = 0;
		double totalWaitTime = 0;
		boolean tellernota = false;
		boolean done = false;
		Customer currentCustomer = null;

		while(done==false){
			for(Customer c: queue){
				c.waitTime++;
			}
			while(customerDeparture(time)){
				Customer c = getCustomer(time);
				queue.add(c);
			}
			if(currentCustomer!=null&&(time-currentCustomer.tellerTime)>=getTransactionTime(currentCustomer)){
				currentCustomer.timeLeft=time;
				tellernota=false;
				totalWaitTime+=currentCustomer.waitTime;
				System.out.println(currentCustomer.toString());
			}
			if(tellernota==false && !queue.isEmpty())
			{
				currentCustomer=queue.remove();
				currentCustomer.tellerTime=time;
				currentCustomer.transTime=getTransactionTime(currentCustomer);
				tellernota=true;
			}
			if(customerList.isEmpty()&&tellernota==false){
				done=true;
			}
			time++;
		}

		System.out.println("\nTotal Customer Count: "+ customerCount + " Customers.");
		System.out.printf("Average Wait: %.2f", totalWaitTime/customerCount);
	} 
}
//Omar Sultani
//Project 6
//Stein
package Project6; 
import java.util.*;   

public class Customer{
    int customerID;
    int arrivalTime;
    int waitTime;
    int tellerTime;
    int transTime;
    int timeLeft;
    ArrayList<Integer>transactionList;
    
    
    public Customer (int i, int j){
    	
      customerID = i;
      arrivalTime = j;
      timeLeft = 0;
      waitTime = 0;
      transTime = 0;
      tellerTime = 0;
    
      transactionList = new ArrayList<Integer>();
    }
    public void AddTransaction(int k) {
      transactionList.add(k);
    }
    
    
    public String toString(){
      return customerID +"              "+arrivalTime+"              "+waitTime+"              "+tellerTime+"              "+transTime+"              "+timeLeft; 
    }
}
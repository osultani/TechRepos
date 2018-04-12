//Omar Sultani
//Comp 182
// 2/5/16
// Project 1


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
@SuppressWarnings("unused")

	public class ProductID {
	 
   int[][] matrix = new int[199][2];
	
	
   public static void main(String[] args) {
    
      ProductID obj = new ProductID(); 
      obj.run();
      obj.printMatrix(obj.matrix);
      System.out.println();
      obj.sort(obj.matrix);
      obj.matrix = obj.addMatrix(obj.matrix);
      obj.printMatrix(obj.matrix);
      
      try {
		PrintWriter pw = new PrintWriter("NewSalesData.txt");
		
		pw.println("ProductID      Units");
		pw.println("");
		for(int i = 0; i < obj.matrix.length; i++){
	    	  if(obj.matrix[i][0] != 0)
	    		  pw.println("  " + obj.matrix[i][0] + "\t \t" + obj.matrix[i][1]);
	      }
		pw.close();
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
   }

	  
   public int[][] addMatrix(int[][] matrix){
   
      int[][] matrix2 = new int[199][2];
   	  int currentID;
      int previousID = matrix[0][0];
   	  int matrix2Index = 0;
      
   	 
      for(int row = 0; row < matrix2.length; row++){
         currentID = matrix[row][0];
      	
         if(currentID != previousID){
        	matrix2Index++;   
         }
         
         matrix2[matrix2Index][0] = matrix[row][0];
         matrix2[matrix2Index][1] += matrix[row][1];
         
         previousID = currentID;
      }
      return matrix2;
   }
		
   public void sort(int [][] matrix){
   	  
      Arrays.sort(matrix, new Comparator<int[]>() {
               
               public int compare(final int[] entry1, final int[] entry2) {
                  if(entry1[0] < entry2[0])
                     return -1;
                  else if(entry1[0] > entry2[0]){
                     return 1;
                  }
                  return 0;
               }
            }
         );
   }
   
   public void printMatrix(int[][] matrix){
	   System.out.println("ProductID     Units");
      for(int i = 0; i < matrix.length; i++){
    	  if(matrix[i][0] != 0)
    		  System.out.println("  " + matrix[i][0] + "\t   - \t" + matrix[i][1]);
      }
   }
   
   public void run() {
    
      String csvFile = "/Users/sulom/Documents/Comp 182 Java Projects/Sorting/src/Data/salesdata.csv";
      BufferedReader br = null;
      String line = "";
      String csvSplitBy = ",";
    
      int row = 0;
      try {
      
         br = new BufferedReader(new FileReader(csvFile));
         br.readLine();
         while ((line = br.readLine()) != null) {
         
            String[] Product = line.split(csvSplitBy);				
            matrix[row][0] = Integer.parseInt(Product[0]);
            matrix[row][1] = Integer.parseInt(Product[1]);
            row++;	
         
         }	
      } 
      catch (FileNotFoundException e) {
         e.printStackTrace();
      } 
      catch (IOException e) {
         e.printStackTrace();
      } 
      finally {
         if (br != null) {
            try {
               br.close();
            } 
            catch (IOException e) {
               e.printStackTrace();
            }
         }
      }
     }	 
}

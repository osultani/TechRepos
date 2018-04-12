//Name: Omar Sultani
//Date: 9/12/15
//Project Info: Project2 - "Guessing Game"
//Description: Game that requires user to guess a random generated number between 1 to 32.




import java.util.Random;
import java.util.Scanner;
public class GuessingGame{

   public static void main(String[] args){
      
        //Creates a new Random object with which to work
      Random rand = new Random();
        
        //Generate a random number to be guessed
      int value = rand.nextInt(32)+1;
        
        //Create a Scanner
      Scanner input = new Scanner(System.in);
      int number = 0;
        
        //Count the number of guesses
      int countGuesses = 0;
        
        //Count smaller guesses
      int smallerGuesses = 0;
        
        //Count larger guesses
      int largerGuesses = 0;
       
   
   
        //Prompt the user to guess the number
      System.out.print("Guess the number I'm thinking of, from 1-32: ");
        
        
        //Loop body
      while (number != value && number != -1){
        
        //Allows user to enter number
         number = input.nextInt();
       
        //Prompt for user guessing correct number                                    
         if (number == value){
            System.out.print("/nYou have guessed the correct number!");
            countGuesses++;
         }
         
         //Prompt for user exiting game   
         else if (number == -1)
            System.out.println("You have exited the game. See ya next time!");
            
         //Prompt for user guessing too large of number    
         else if (number > value){
            System.out.print("Your guess is larger than the random value! Guess again: ");
            countGuesses++;
            largerGuesses++;
         }
         
         //Prompt for user guessing too small of number
         else if (number < value){
            System.out.print("Your guess is smaller than the random value! Guess again: ");
            countGuesses++;
            smallerGuesses++;
         }
      }
      
      System.out.println("Number -" + countGuesses);
      System.out.println("SmallNumber - " + smallerGuesses);
                  
     
         
      // For loop asterisks/Display to user total number of guesses, smaller guess count, larger guess count
        
    /*  System.out.println("\nTotal Number of Guesses: " + countGuesses);
      for(int i = 0; i < countGuesses; i++){
         System.out.printf("*");
      }
      
      System.out.println("\nSmaller Guesses: " + smallerGuesses);
      for(int i = 0; i< smallerGuesses; i++){
         System.out.printf("*");
      }
      
      
      System.out.println("\nLarger Guesses: " + largerGuesses);
      for (int i = 0; i < largerGuesses; i++){
         System.out.printf("*");
      }
         */
   }
}        
        

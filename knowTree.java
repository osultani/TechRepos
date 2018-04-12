package knowTree;

//Omar Sultani
//Project 7
//Stein


import java.util.*;
import java.io.*;



@SuppressWarnings("unused")
public class knowTree {

	private static Scanner input;

	public static void main(String[] args) {
		System.out.println("Hi there! Would you like to play a guessing game?");
		System.out.println("Think of a major city in the United States!");
		System.out.println("Please type 'Yes or No' to answer each question!");
		System.out.println("------------------------------------------------");
		
		input = new Scanner(System.in);

		Node n1 = new Node("\nDoes it snow in this city?: ");
		Node n2 = new Node("\nIs it on the West Coast?: ");
		Node n3 = new Node("\nIs it New York?: ");
		Node n4 = new Node("\nIs it Los Angeles?: ");
		Node n5 = new Node("\nIs it in the Mid-West?: ");
		Node n6 = new Node("\nSince it is not in the Mid-West or West Coast, it must be on the East Coast! Is it Orlando?: ");
		Node n7 = new Node("\nIs it Chicago?: ");



		n1.left = n3;
		n1.right = n2;

		n2.left = n4;
		n2.right = n5;

		n5.left = n7;
		n5.right = n6;



		boolean done = false;
		while (!done) {

			Node current = n1;
			Node parent = null;

			while (current != null) {

				System.out.print(current);
				String answer = input.next();
				parent = current;

				if (answer.toLowerCase().equals("yes")) {

					current = current.left;

					if (current == null) {

						System.out.print("\nI guessed the correct City! Would you like to continue? ");

					}

				} else if (answer.toLowerCase().equals("no")) {

					current = current.right;



					if (current == null) {

						System.out.print("\nNo! I give up! What city is it?: ");
						String newGuess = input.next();
						Node n = new Node("Is it " + newGuess + "?");



						input.nextLine();

						System.out.println("\nPlease type a question whose answer is yes for " + newGuess + " but no for the previous question.");

						String question = input.nextLine();
						parent.right = new Node(question);
						parent.right.left = n;

						System.out.println("\nWould you like to keep playing?: ");

					}

				} else {

					System.out.println("Invalid Input");

				}
			}


			String choice = input.next();

			if(choice.toLowerCase().equals("no")){

				System.out.println("\nThanks for playing!");
				done = true;

			}
		}

	}



}

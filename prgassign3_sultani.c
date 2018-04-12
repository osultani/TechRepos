//Omar Sultani
//Comp 222 Programming Assignment 3 - Hamming Code
//Class Meeting Time 11:00AM

//To check a Hamming code for a single-bit error, and to report and correct the error (if any).
//The program reads in a Hamming Code which may or may not have a single error.  
//It then determines which bit, if any, is incorrect and corrects it.  
//Finally, when requested by the user, it displays which bit was in error along with the corrected word.  
//If there is no error, it reports that as well.

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

//Global variables within code.

char * positionNum = NULL;
int hamLength;
int parity;
int maxLength;


//Maximum hamming code input from user in a while loop
//Asks for the selection, asks for the maximum length and parity
//Returns back to the menu 

void enterMenuInfo(FILE *file)

{
            printf("Enter The Maximum Length: \n");
            fscanf(file, "%d", &maxLength );
            printf("%d\n", maxLength);
			
			
            printf("Enter The Parity (0 = Even, 1 = Odd): \n");
            fscanf(file,"%d", &parity );
            printf("%d\n", parity);
			
            positionNum = (char*) malloc(maxLength * sizeof(char));
  return;
}

//Checks the actual hamming code
//Enter data regarding the hamming code structure

void hammingCode(FILE *file)
{
	
 int i;
 int j;
 int k;
 int dataBit = 0;
 int parityBit = 0;

 
 
            printf("\nEnter The Hamming Code: \n");
            fscanf(file, "%s", positionNum);
            printf("%s\n", positionNum);
            hamLength = strlen(positionNum);
			 
            if(hamLength>maxLength) 
			{
			printf("");
            printf("***Invalid Entry - Exceeds Maximum Code Length of %d\n", maxLength);
            printf("");
			
			return;
            }


 //3 beginning, inner and outer for loops to count the interations of the parity bit and data bits
 //Comparing i to 1, then j to i, then k to j allowing a 3 loop process. -Begginning, middle, and outer loops.
 //First iteration for loop.
	for(i = 1; i < hamLength; i = i * 2)
	{
        parityBit = parity;

//Second iteration for loop.
    for(j = i; j <= hamLength; j = j + (i * 2))
	{     
	

//Third iteration for loop.	 
    for(k = j; k < j + i && k <= hamLength; k += 1)
	{
                parityBit = parityBit ^ (positionNum[hamLength - k] - '0');
            }
        }
		
        dataBit = dataBit + (parityBit * i);
    } 


//If statement checking result from user inputted data. Returns statement if there is an error.
//Returns nothing if data is acceptable. 
if (dataBit == 0)
        printf("***There Is No Bit Error \n");
	
	
    else{
		
        printf("***There Is An Error In Bit: %d\n", dataBit);
		
        if (positionNum[hamLength - dataBit] == '0')

        positionNum[hamLength - dataBit] = '1';
			
        else
        positionNum[hamLength - dataBit] = '0';
        printf("***The Corrected Hamming Code Is: %s\n", positionNum);
		printf(" ");
	
    }



  return;
}

//Console menue for user to read and input into.
//File data reader into code.

int main()
{

    FILE *file;
    file = fopen("hc_data_2016.txt", "r");
    int choice;
	
	//While menu of options to choose from
    while(choice != 3) {
		printf("");
        printf("\nOmar Sultani\n");
        printf("Error Detection/Correlation: \n");
        printf("---------------------- \n");
        printf("1) Enter Parameters  \n");
        printf("2) Check Hamming Code \n");
        printf("3) Quit\n");
        printf("Enter selection: \n");
		printf("");

		
		//User enters choice from menu here.
        fscanf(file, "%d", &choice);
        printf("%d\n", choice);
		
		
		//Menu option 1
        if(choice == 1) {
         enterMenuInfo(file);
		 
        }
		
		//Menu option 2
        else if (choice == 2){
        hammingCode(file);
		
        }
		
		//Menu option 3
        else if (choice == 3) {
			
         if (positionNum != NULL)
         free (positionNum);
            fclose(file);
			printf("");
            printf("***Program Terminated Normally");
            exit(EXIT_SUCCESS);
        }
		
		//Chooses incorrect menu option
        else printf("Not A Valid Selection, Please Choose Again \n");
    }

return 1;
}

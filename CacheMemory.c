#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int memorySize;
int cacheSize;
int blockSize;


void option1(){
	
	printf("Enter main memory size (words): \n");
	scanf("%d", &memorySize);
	
	printf("Enter cache size (words): \n");
	scanf("%d", &cacheSize);
	
	printf("Enter block size (words): \n");
	scanf("%d", &blockSize);
}

void option2(){
	
	
	printf("Testing for option2\n");

}

void option3(){
	
	printf("Testing for option3\n");

	
}




int main(){
  
   int choice;
   
   do{
	  printf("\n");
      printf("Omar Sultani\n");
      printf("Main memory to Cache memory mapping: \n");
	  printf("-----------------------\n");
	  printf("1)Enter Configuration Parameters\n");
	  printf("2)Read from cache\n");
	  printf("3)Write to cache\n");
	  printf("4)Exit\n");
	  
	  printf("Enter choice: \n");
   
      scanf("%d",&choice);
	  printf("\n");
   
      if( choice == 1){
         option1 ();
      
      }       
      if (choice == 2)
      {
         option2();
      
      }
      if (choice == 3)
      {option3 ();
      
	  }
      if (choice == 4){
      }
   }
   while((choice== 1||choice== 2||choice== 3)&& (choice!= 4));

}
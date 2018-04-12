//Omar Sultani
//Lab 2 Forking and Waiting
//Comp 322


#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define BUFSIZE 1024

int main(int argc, char *argv[])
{
    int count = argc -1;
    printf("Count = %d\n", count);
    int i, cpid;

    if(count == 0)
    {
        printf("No files, no children forked.\n");
    }



    for(i = 1; i <= count; i++)
    {
        cpid = fork();
        if(cpid == -1)
        {
            perror("fork");
            exit(EXIT_FAILURE);
        }
        else if(cpid == 0)
        {
            sleep(1);
            exit(0);
        }
        else
        {
           
         
            printf("Filename: %s", argv[i]);
            printf("\t PID IS: %i\n", cpid);
        
        }

    }

    while (wait(NULL) > 0);

  printf("Parent Process Complete - PID: %d \n", getpid());
  system("ps -H");

    exit(0);
}
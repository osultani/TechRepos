//Omar Sultani
//Lab 3 PART 2 File Permissions and Directory Information
//Comp 322

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <errno.h>
#include <pwd.h>
#include <grp.h>
#include <dirent.h>
#include <pthread.h>


#define BUFSIZE 1024




void filePermissions(int argc, char *argv[]);


int main(int argc, char *argv[])
{

    if (argc == 1)
    {

        int count = 0;
        struct dirent *directory;
        DIR *pdirectory;

// " . " - current directory
// " .. " - parent directory 
//Use dirent to populate ARG C AND ARG V through every iterations 

        pdirectory = opendir(".");

        printf("No files, no children forked.\n");
        char **point = (char**)malloc(sizeof(char*)*1);

        while(directory = readdir(pdirectory)){
            point = realloc(point, sizeof(char*)*(count+2));
            ++count;
            point[count] = directory -> d_name;
        }
        closedir(pdirectory);
        argc = count;
        argv = point;
    }

    filePermissions(argc, argv);
}



void filePermissions(int argc, char *argv[]){

    int count = argc -1;
    int i, cpid;
    int fileMode;

    struct passwd pwd = *getpwuid(getuid());
    uid_t userID = pwd.pw_uid;
    gid_t groupID = pwd.pw_gid;

    const char *homedir = pwd.pw_dir;


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

            struct stat statBuf;         
            stat(argv[i], &statBuf);
            fileMode = statBuf.st_mode;

            printf("\nFile: %s",  argv[i]);
            printf("\nDirectory: %s\n", homedir);

            if(userID == statBuf.st_uid){

                printf("You have Owner Permissions:\t");
                if (fileMode & S_IRUSR) {
                    printf(" Read");
                }
                if (fileMode & S_IWUSR) {
                    printf(" Write");
                }
                if (fileMode & S_IXUSR) {
                    printf(" Execute");
                }
            }

            else if(groupID == statBuf.st_gid){

                printf("You have Group Permissions:\t");
                if (fileMode & S_IRGRP) {
                    printf(" Read");
                }
                if (fileMode & S_IWGRP) {
                    printf(" Write");
                }
                if (fileMode & S_IXGRP) {
                    printf(" Execute");
                }
            }

            else {
                printf("You have General Permissions:\t");
                if (fileMode & S_IROTH) { 
                    printf(" Read");
                }
                if (fileMode & S_IWOTH) {
                    printf(" Write");
                }
                if (fileMode & S_IXOTH) {
                    printf(" Execute");
                }
            }
            printf("\n");
            exit(0);
        }
    }

    while(wait(NULL) > 0);

    exit(0);
}


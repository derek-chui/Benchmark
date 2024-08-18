#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>
#include <ctype.h>
#include <time.h>
#include <stdlib.h>

void printAge(int *age);
void bubbleSort(int array[], int size);
void printArray(int array[], int size);

typedef struct
{
    char name[12];
} Person;

typedef char twentyFiveLetters[25];

int main()
{
    printf("\"");
    float gpa = 2.05;
    //%8 is space before number
    //%-8 is space after number
    //.2 is to display 2 digits after the decimal
    printf("gpa is %8.2f\n", gpa);
    //char c, char array s, float f, double lf, bool d 
    //numeric char d (ascii), numeric unsigned char d (ascii), short and unsigned short d
    //int d, unsigned int u, long long lld, unsigned long long llu
    //float 4 bytes, dobule 8 bytes
    //unsigned = no negative numbers so double positive storage, signed by default
    //short 2 bytes, int 4 bytes, long long 8 bytes

    //char c, string s, float f, double lf, int d
    //decimal precision .1, 1 minimum field width, - left align
    const float PI = 3.14159;
    //char name[25];
    //fgets(name, 25, stdin); //input with spaces
    //name[strlen(name)-1] = '\0' //get rid of default new line from stdin
    //math functions: fabs(-100) absolute value, log(3), sin(45), cos(45), tan(45)
    //toupper(x), strlwr(x), strupr(x)
    //strcat(x, y), strncat(x, y, 1) with letters included, strcpy(x, y), strncpy(x, y, 1)
    //strset(x, '?') set all char of string to given char, strnset(x, 'x', 1), strrev(x) reverse
    //strlen(x), strcmp(x, y), strncmp(x, y, 1), ignore case: strcmpi(x, x), strnicmp(x, x, 1)
    double prices[2][2] = {
                            {5.0, 10.0},
                            {2.0, 4.0}
                        };

    int rows = sizeof(prices)/sizeof(prices[0]);
    int cols = sizeof(prices[0])/sizeof(prices[0][0]);
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            printf("$%.2lf ", prices[i][j]);
        }
        printf("\n");
    }

    //sorting
    int array[] = {9, 1, 8, 2};
    int size = sizeof(array)/sizeof(array[0]);
    bubbleSort(array, size);
    printArray(array, size);

    //structs
    Person person1;
    strcpy(person1.name, "John");
    printf("%s\n", person1.name);

    //typedef
    twentyFiveLetters username = "Hello";

    Person person2;
    strcpy(person2.name, "Joe");
    Person people[] = {person1, person2};
    for (int i = 0; i < sizeof(people)/sizeof(people[0]); i++)
    {
        printf("%s\n", people[i].name);
    }

    srand(time(0));
    int randNum = (rand() % 6) + 1;
    printf("%d\n", randNum);

    //scanf("%c") clears \n from input buffer

    //bitwise operators & | ^ << >> ~

    //pointers
    int age = 19;
    int *pAge = NULL;
    pAge = &age;
    //when printed &age is the same as pAge
    //and age is the same as *pAge
    printAge(pAge);

    //files
    FILE *pFw = fopen("test.txt", "w"); //"r" for read, a to append
    //absolute file path -> fopen("C:\\Users\\John\\Desktop\\test.txt", "w");
    fprintf(pFw, "Hello");
    fclose(pFw);

    // if(remove("test.txt") == 0)
    // {
    //     printf("File removed");
    // }
    // else
    // {
    //     printf("File not removed");
    // }

    FILE *pFr = fopen("test.txt", "r");
    char buffer[255];
    if (pFr == NULL)
    {
        printf("no file");
    }
    else
    {
        while(fgets(buffer, 255, pFr) != NULL)
        {
            printf("%s\n", buffer);
        }
        fclose(pFr);
    }

    return 0;
}

void printAge(int *age)
{
    printf("%d\n", *age);
}

void bubbleSort(int array[], int size)
{
    for (int i = 0; i < size - 1; i++)
    {
        for (int j = 0; j < size - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

void printArray(int array[], int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%d ", array[i]);
    }
}
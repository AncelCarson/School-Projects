// Ancel Carson
// 3/30/17

#include <iostream>
#include <fstream>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
using namespace std;

//Prototype Statements
int randomNum ();

int main ()
{
   ofstream classGrades;
   classGrades.open("Text Files/ClassScores.txt");
   int numRows = 250, numCols = 4, c, r, Num;
   int numbers[numRows][numCols];
   for (r = 0; r < numRows; r++)
   {
      for (c = 0; c < numCols; c++)
      {
         Num = randomNum();
         numbers[r][c] = Num;
      }
   }
   for (r = 0; r < numRows; r++)
   {
      for (c = 0; c < numCols; c++)
      {
         classGrades << numbers[r][c];
         if (c != 3)
         {
            classGrades << " ";
         }
      }
      classGrades << endl;
   }
   classGrades.close();
   return 0;
}

int randomNum ()
{
   int result;
   result = rand() % 50+50;
   return result;
}

// Ancel Carson
// 3/10/17

#include <iostream>
#include <fstream>
using namespace std;

int main ()
{
   ifstream inputNumbers;
   inputNumbers.open("Text files/numbers.txt");
   int numRows, numCols, c;
   inputNumbers >> numRows >> numCols;
   int numbers[numRows][numCols];
   string names[numCols];
   for (int r = 0; r < numRows; r++)
   {
      for (c = 0; c < numCols; c++)
      {
         inputNumbers >> numbers[r][c];
      }
   }
   c = 0;
   while(!inputNumbers.eof())
   {
      inputNumbers >> names[c];
      c++;
   }
   return 0;
}
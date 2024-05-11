// Ancel Carson
// 1/27/17

#include <iostream>
using namespace std;

int main ()
{
   float theNumbers[3][4];
   float theAverage, theSum=0;
   for (int r = 0; r <= 2; r++)
   {
      for (int c = 0; c <= 3; c++)
      {
         cout << "Please enter the entiger for row " << r+1 << " and column " << c+1 << endl;
         cin >> theNumbers[r][c];
         cout << endl;
      }
   }
   for (int c = 0; c <= 3; c++)
   {
      for (int r = 0; r <= 2; r++)
      {
         theSum = theSum+theNumbers[r][c];
      }
      theAverage = theSum/3.0;
      cout << "The average for column " << c+1 << " is: " << theAverage << endl;
      theSum = 0;
   }
   return 0;
}
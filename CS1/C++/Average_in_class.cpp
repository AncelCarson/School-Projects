#include <iostream>
using namespace std;

int main ()
{
   // Ancel Carson
   float number, subTotal, divisor, theAverage; 
   int loops;
   divisor = 0;
   subTotal = 0;
   cout << "How many numbers do you have?\n";
   cin >> loops;
   cout << "Enter your first number.\n";
   cin >> number;
   divisor = 1;
   subTotal = number;
   for (int n=1; n<loops; n++)
   {
      cout << "Enter your next number.\n";
      cin >> number;
      subTotal = subTotal+number;
      divisor = divisor+1;
   }
   theAverage = subTotal/divisor;
   cout << "The average is " << theAverage;
   return 0;
}
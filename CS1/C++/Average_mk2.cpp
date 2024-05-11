#include <iostream>
using namespace std;

int main ()
{
   // Ancel Carson
   float number, subTotal, divisor, theAverage;
   divisor = 0;
   subTotal = 0;
   cout << "Enter your first number.\n";
   cin >> number;
   divisor = 1;
   subTotal = number;
   while (true)
   {
      cout << "Enter your next number. If you are finished type '0000'.\n";
      cin >> number;
      if (number == 0000)
      {
         break;
      }
      else
      {
         subTotal = subTotal+number;
         divisor = divisor+1;
      }
   }
   theAverage = subTotal/divisor;
   cout << "The average is " << theAverage;
   return 0;
}
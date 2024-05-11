#include <iostream>
using namespace std;

int main ()
{
   // Ancel Carson
   float number, subTotal, divisor, theAverage, loops, n;
   divisor = 0;
   subTotal = 0;
   n = 1;
   cout << "How many numbers do you have?\n";
   cin >> loops;
   cout << "Enter your first number.\n";
   cin >> number;
   divisor = 1;
   subTotal = number;
   while (n<loops)
   {
      cout << "Enter your next number.\n";
      cin >> number;
      subTotal = subTotal+number;
      divisor = divisor+1;
      n++;
   }
   theAverage = subTotal/divisor;
   cout << "The average is " << theAverage;
   return 0;
}

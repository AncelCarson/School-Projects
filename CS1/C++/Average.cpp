#include <iostream>
using namespace std;

int main ()
{
   // Ancel Carson
   float num1, num2, num3, num4, the_sum, theAverage;
   cout << "Please enter your first integer.\n";
   cin >> num1;                                        // recieve first variable
   cout << "Please enter your second integer.\n";
   cin >> num2;                                        // recieve second variable
   cout << "Please enter your third integer.\n";
   cin >> num3;                                        // recieve third variable
   cout << "Please enter your fourth integer.\n";
   cin >> num4;                                        // recieve fourth variable
   the_sum = num1+num2+num3+num4;
   theAverage = the_sum/4.0;
   cout << "The average is " << theAverage << endl;
   return 0;
}
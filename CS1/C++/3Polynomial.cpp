// Ancel Carson
// 1/27/17

#include <iostream>
#include <cmath>
using namespace std;

//Prototype Statements
float Poly(float, float, float, float, float);

int main ()
{
   float coe1, coe2, coe3, coe4, xvalue, answer;
   cout << "Enter first coefficient integer.\n";
   cin >> coe1;
   cout << "Enter second coefficient integer.\n";
   cin >> coe2;
   cout << "Enter third coefficient integer.\n";
   cin >> coe3;
   cout << "Enter fourth coefficient integer.\n";
   cin >> coe4;
   cout << "Enter your x value.\n";
   cin >> xvalue;
   answer = Poly (coe1, coe2, coe3, coe4, xvalue);
   cout << "f(x)=";
   if (coe1 != 0)
   {
      cout << coe1 << "x^3";
   }
   if (coe2 != 0)
   {
      if (coe2 > 0)
      {
         if (coe1 == 0)
         {
            cout << coe2 << "x^2";
         }
         else
         {
            cout << "+" << coe2 << "x^2";
         }
      }
      else
      {
         cout << coe2 << "x^2";
      }
   }
   if (coe3 != 0)
   {
      if (coe3 > 0)
      {
         if (coe1 == 0)
         {
            if (coe2 == 0)
            {
               cout << coe3 << "x";
            }
            else
            {
               cout << "+" << coe3 << "x";
            }
         }
         else
         {
            cout << "+" << coe3 << "x";
         }
      }
      else
      {
         cout << coe3 << "x";
      }
   }
   if (coe4 != 0)
   {
      if (coe4 > 0)
      {
         if (coe1 == 0)
         {
            if (coe2 == 0)
            {
               if (coe3 == 0)
               {
                  cout << coe4 << endl;
               }
               else
               {
                  cout << "+" << coe4 << endl;
               }
            }
            else
            {
               cout << "+" << coe4 << endl;
            }
         }
         else
         {
            cout << "+" << coe4 << endl;
         }
      }
      else
      {
         cout << coe4 << endl;
      }
   }
   else if (coe1 == 0)
   {
      if (coe2 == 0)
      {
         if (coe3 == 0)
         {
            if (coe4 == 0)
            {
               cout << "0\n";
            }
         }
      }
   }
   else
   {
      cout << endl;
   }
      cout << "f(" << xvalue << ")=" << answer << endl;
   return 0;
}

//Finds the answer for a user defined three degree polynomial
float Poly (float pt1, float pt2, float pt3, float pt4, float xvalue)
{
   float result;
   result = pt1*pow(xvalue,3)+pt2*pow(xvalue,2)+pt3*xvalue+pt4;
   return result;
}
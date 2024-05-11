// Ancel Carson
// 1/27/17

#include <iostream>
using namespace std;

int main ()
{
   float total=0, stopNum;
   stopNum = 1000000;
   for (int n=1; n<=stopNum; n++)
   {
      cout << n << endl;
      total = total+1;
   }
   cout << total;
   return 0;
}
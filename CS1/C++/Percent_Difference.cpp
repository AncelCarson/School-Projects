// Ancel Carson
// 1/27/17

#include <iostream>
#include <cmath>
using namespace std;

//Prototype Statement
float percentDiff(float, float);

int main ()
{
   float measurement1, measurement2, answer;
   int count = 0;
   cout << "Please enter measurement 1.\n";
   cin >> measurement1;
   cout << "Please enter measurement 2.\n";
   cin >> measurement2;
   measurement1 = measurement1-.00001;
   do
   {
      measurement1 = measurement1+.00001;
      answer = percentDiff(measurement1, measurement2);
      count++;
   }while(answer >= .5);
   cout << "The final value of measurement 1 is " << measurement1 << endl;
   cout << "The percent difference is " << answer << endl;
   cout << "The value of measurement 1 was changed " << count-1 << " times.\n";
   return 0;
}

//Catulates the percent difference between two measurements
float percentDiff(float m1, float m2)
{
   float result;
   result = (abs(m1-m2)/((m1+m2)/2))*100;
   return result;
}
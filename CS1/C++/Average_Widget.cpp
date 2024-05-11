// Ancel Carson
// 2/27/17

#include <iostream>
using namespace std;

//Prototype Statements
float findAverage (int [], int);

int main ()
{
   string names [10];
   int numOfWidgets [10], count;
   float theAverage;
   cout << "How many people worked today?\n";
   cin >> count;
   cout << "Enter employee name then number of widgets made.\n" ;
   for (int i = 0; i < count; i++)
   {
      cin >> names[i];
      cin >> numOfWidgets[i];
   }
   for (int c = 0; c < count; c++)
   {
      cout << names[c] << " " << numOfWidgets[c] << endl;
   }
   theAverage = findAverage (numOfWidgets, count);
   cout << endl << "The average number of widgets for today is " << theAverage << endl;
   return 0;
}

//Averages the number of widgets
float findAverage (int numOfWidgets [], int theCount)
{
   float result, theSum = 0.0;
   for (int i = 0; i < theCount; i++)
   {
      theSum = theSum+numOfWidgets[i];
   }
   result = theSum/theCount;
   return result;
}

#include <iostream>
#include <fstream>

using namespace std;

// prototypes
float myMax(float [], float);
float myAvg(float [], float);

int main()
{
int cols = 8;
int rows = 3;
float myArray[rows][cols];
float tempArray[cols], dayMax[rows];
int r1 = 0;
float dayMaxAvg;

while(r1 < rows){
   for(int c = 0; c < cols; c++){
      cout << "Please enter the value for day " << r1+1 << " Truck " << c+1 << endl;
      cin >> myArray[r1][c];
   }
   r1++;
}

for(int r2 = 0; r2 < rows; r2++){
   for(int c =0; c < cols; c++){
      tempArray[c] = myArray[r2][c];
   }

   dayMax[r2] = myMax(tempArray, cols);
   cout << dayMax[r2] << endl;
}

   dayMaxAvg = myAvg(dayMax, rows);

   cout << "\n" << dayMaxAvg << endl;

   cout << "The program is finished. Thanks for using our program\n";

return 0;
}// end of main

// function finds the maximum value in an array
float myMax(float theArray[], float count){

float maxValue = 0, tempMax;

   for(int n = 0; n < count; n++){
      if(theArray[n] > maxValue){
         maxValue = theArray[n];
      }
   }

return maxValue;
}

// function finds the average value in an array
float myAvg(float theArray[], float count){

float avgValue, sumOfValues = 0;

   for(int n = 0; n < count; n++){
      sumOfValues = sumOfValues + theArray[n];
   }

   avgValue = sumOfValues/count;

return avgValue;
}

// Ancel Carson
// 3/8/17

#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

//Prototype Statements
float totalDistance(float, float, float, float);

int main ()
{
   float startingX, startingY, endingX, endingY, tripCount = 0, distTraveled = 0, flatRate, perMileCharge, perMileCost;
   float tripCost[30];
   cout << "How many trips did you take?\n";
   cin >> tripCount;
   for (int n = 0; n < tripCount; n++)
   {
      cout << "What was the starting x position of trip " << n+1 << "?\n";
      cin >> startingX;
      cout << "What was the starting y position of trip " << n+1 << "?\n";
      cin >> startingY;
      cout << "What was the ending x position of trip " << n+1 << "?\n";
      cin >> endingX;
      cout << "What was the ending y position of trip " << n+1 << "?\n";
      cin >> endingY;
      distTraveled = totalDistance(startingX, startingY, endingX, endingY);
      if (distTraveled > 20)
      {
         flatRate = 35;
         perMileCharge = 1.50;
      }
      else if (distTraveled > 10)
      {
         flatRate = 29;
         perMileCharge = 1.75;
      }
      else if (distTraveled > 3)
      {
         flatRate = 27;
         perMileCharge = 2.00;
      }
      else if (distTraveled > 1)
      {
         flatRate = 25;
         perMileCharge = 2.25;
      }
      else
      {
         flatRate = 25;
         perMileCharge = 0;
      }
      perMileCost = distTraveled*perMileCharge;
      tripCost[n] = perMileCost+flatRate;
   }
   for (int n = 0; n < tripCount; n++)
   {
      cout << "Trip " << n+1 << " cost $" << fixed << setprecision(2) << tripCost[n] << endl;
   }
   return 0;
}

//Determines number of miles traveled
float totalDistance(float startX, float startY, float endX, float endY)
{
   float distX, distY, result;
   distX = abs(startX-endX);
   distY = abs(startY-endY);
   result = distX+distY;
   return result;
}

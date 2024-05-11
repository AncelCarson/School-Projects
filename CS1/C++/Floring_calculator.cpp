#include <iostream>
using namespace std;

int main ()
{
   // Ancel Carson
   float sizeFt, sizeYd, underLayer, flooringC, xRoom, yRoom, totalCost, priceUnder, priceFloor;
   const float fixedCost = 100;
   string cFirst, cLast, sLast;
   cout << "What is your last name?\n";
   cin >> sLast;                                        // recieve Sales repersentative's last name
   cout << "What is the first name of client?\n";
   cin >> cFirst;                                       // recieve client's first name
   cout << "What is the last name of client?\n";
   cin >> cLast;                                        // recieve client's last name
   cout << "What is the first distance wall to wall in feet?\nft:";
   cin >> xRoom;                                        // recieve x-axis
   cout << "What is the second distance wall to wall in feet?\nft:";
   cin >> yRoom;                                        // recieve y-axis
   cout << "What is the price of the flooring in square yards?\n$";
   cin >> flooringC;                                    // recieve flooring cost
   cout << "What is the price of the underlayer in square yards?\n$";
   cin >> underLayer;                                   // recieve underlayer cost
   sizeFt = xRoom*yRoom;                                // find square feet
   sizeYd = sizeFt*.1111111;                            // convert to yards
   priceFloor = sizeYd*flooringC;                       // find price of flooring
   priceUnder = sizeYd*underLayer;                      // find price of underlayer
   totalCost = priceFloor+priceUnder+fixedCost;         // find total cost
   cout << "\nCost estimate for " << cLast << ", " << cFirst << endl;
   cout << "--------------------\n" << "Room size: " << sizeFt << " square feet\nTotal number of square yards: " << sizeYd << endl;
   cout << "--------------------\n" << "Installation cost: $" << fixedCost << "\nCost of under layer: $" << priceUnder << "\nCost of flooring: $" << priceFloor << endl;
   cout << "--------------------\n" << "Total cost: $" << totalCost << endl;
   cout << "--------------------\n" << "Sales person: " << sLast << endl;
   return 0;
}
// Ancel Carson
// 1/27/17

#include <iostream>
using namespace std;

int main ()
{
   float nOz, commission, incomeTax, SSTax, net, mType, metalC, orderC;
   const float commissionP=.16, incomeP=.085, SSTaxP=.0575;
   const float type1=125.56, type2=327.48, type3=79.24, type4=452.14;
   string firstN, lastN;
   cout << "What is your first name?" << endl;
   cin >> firstN;
   cout << "What is your last name?" << endl;
   cin >> lastN;
   cout << "What type of metal are you using?" << endl;
   cin >> mType;
   if (mType == 1)
   {
      metalC = type1;
   }
   else if (mType == 2)
   {
      metalC = type2;
   }
   else if (mType == 3)                               //Sets the metal type
   {
      metalC = type3;
   }
   else if (mType == 4)
   {
      metalC = type4;
   }
   cout << "How many ounces do you have?" << endl;
   cin >> nOz;
   orderC = nOz*metalC;                               //Finds total of the order
   commission = orderC*commissionP;                   //Finds Commission of rep.
   incomeTax = commission*incomeP;                    //Finds the income tax
   SSTax = commission*SSTaxP;                         //Finds social securty tax
   net = commission-incomeTax-SSTax;                  //Subtracts tax
   cout << firstN << " " << lastN << endl;
   cout << "--------------------" << endl;
   cout << "number of oz: " << nOz << "oz\n" << "Total of order: $" << orderC << endl;
   cout << "--------------------" << endl;
   cout << "Sales commission: $" << commission << "\nIncome tax: $" << incomeTax << "\nSS tax: $" << SSTax << endl;
   cout << "--------------------" << endl;
   cout << "Net income: $" << net << endl;
   return 0;
}
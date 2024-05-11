// Ancel Carson
// 3/3/17

#include <iostream>
#include <iomanip>
using namespace std;

//Prototype Statements
float subTotal (float[]);
float widgetTax (float);
void menu ();

int main ()
{
   string widgetType[5], company;
   char widget;
   float widgetPrice[5], widgetNum[5], widgetTotal[5], subtotal, tax, total;
   int widgetNumber;
   for (int n = 0; n <= 5; n++)
   {
      widgetPrice[n] = 0;
      widgetNum[n] = 0;
      widgetTotal[n] = 0;
   }
   cout << "What company are you buying for?\n";
   cin >> company;
   cout << "How many different widgets are you purchasing?\n";
   cin >> widgetNumber;
   for (int n = 0; n < widgetNumber; n++)
   {
      cout << "Which widget are you buying? For help menu press h.\n";
      cin >> widget;
      if (widget == 'h')
      {
         menu ();
         cout << "Select a widget.\n";
         cin >> widget;
      }
      switch (widget)
      {
         case 'w': widgetType[n] = "wWidgets";
                   break;
         case 'p': widgetType[n] = "pWidgets";
                   break;
         case 'm': widgetType[n] = "mWidgets";
                   break;
         case 'g': widgetType[n] = "gWidgets";
                   break;
         case 'c': widgetType[n] = "cWidgets";
                   break;
      }
      cout << "How many " << widgetType[n] << " are you purchasing?\n";
      cin >> widgetNum[n];
      cout << "What is the price for each of the " << widgetType[n] << "?\n$";
      cin >> widgetPrice[n];
      widgetTotal[n] = widgetNum[n]*widgetPrice[n];
   }
   subtotal = subTotal (widgetTotal);
   tax = widgetTax (subtotal);
   total = subtotal+tax;
   cout << "Customer: " << company << endl;
   cout << "----------------------------------------------\n";
   cout << "Amount\tDescription\tPrice/each\tCost\n";
   for (int n = 0; n < widgetNumber; n++)
   {
      cout << widgetNum[n] << "\t" << widgetType[n] << "\t$" << widgetPrice[n] << " \t\t$" << widgetTotal[n] << endl;
   }
   cout << fixed << setprecision(2);
   cout << "----------------------------------------------\n";
   cout << "\t\t\tSubtotal\t$" << subtotal << endl;
   cout << "\t\t\tTax\t\t$" << tax << endl;
   cout << "----------------------------------------------\n";
   cout << "\t\t\tTotal\t\t$" << total << endl;
   return 0;
}

void menu ()
{
   cout << "Press w for wWidgets\n";
   cout << "Press p for pWidgets\n";
   cout << "Press m for mWidgets\n";
   cout << "Press g for gWidgets\n";
   cout << "Press c for cWidgets\n";
}

float subTotal (float widgetTotal[])
{
   float result = 0;
   for (int n = 0; n < 5; n++)
   {
      result = result+widgetTotal[n];
   }
   return result;
}

float widgetTax (float number)
{
   float result;
   result = number*.0825;
   return result;
}

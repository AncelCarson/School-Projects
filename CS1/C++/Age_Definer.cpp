#include <iostream>
using namespace std;

int main ()
{
   // Ancel Carson
   int age;
   string name, catagory;
   cout << "What is your first name?\n";
   cin>> name;
   cout << "Please enter your age.\n";
   cin >> age;
   if (age<25)
   {
      catagory = "young";
   }
   else if (age<45)
   {
      catagory = "mature";
   }
   else if (age<60)
   {
      catagory = "old";
   }
   else
   {
      catagory = "over the hill";
   }
   cout << name << " is " << age << " so he is in the " << catagory << " group." << endl;
   return 0;
}

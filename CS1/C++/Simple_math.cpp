// Ancel Carson
// 2/2/17

#include <iostream>
using namespace std;

//Prototype statements
void menu ();
float addThem (float,float);
float subThem (float, float);
float multThem (float, float);
float divThem (float, float);

int main ()
{
   float num1, num2, answer;
   char operation;
   int choice;
   menu ();
   cout << "Please choose which opperation you would like.\n";
   cin >> choice;
   cout << "Please choose your first integer\n";
   cin >> num1;
   cout << "Please choose your second integer\n";
   cin >> num2;
   switch (choice)
   {
      case 1: answer = addThem (num1, num2);
              operation = '+';
              break;
      case 2: answer = subThem (num1, num2);
              operation = '-';
              break;
      case 3: answer = multThem (num1, num2);
              operation = 'x';
              break;
      case 4: answer = divThem (num1, num2);
              if (num2 == 0)
              {
                 cout << "Divisor cannot be 0 program will now terminate.\n";
                 return 1;
              }
              operation = '/';
              break;
   }
   cout << num1 << " " << operation << " " << num2 << " = " << answer << endl;
   return 0;
}

//Displays opperational choices
void menu ()
{
   cout << "1) Addition\n";
   cout << "2) Subtraction\n";
   cout << "3) multiplication\n";
   cout << "4) Division\n";
}

//Recieves two numbers and adds them
float addThem (float var1, float var2)
{
   float result;
   result = var1+var2;
   return result;
}

//Recieves two numbers and subtracts them
float subThem (float var1, float var2)
{
   float result;
   result = var1-var2;
   return result;
}

//Recieves two numbers and multiplies them
float multThem (float var1, float var2)
{
   float result;
   result = var1*var2;
   return result;
}

//Recieves two numbers and divides them
float divThem (float var1, float var2)
{
   float result;
   result = var1/var2;
   return result;
}
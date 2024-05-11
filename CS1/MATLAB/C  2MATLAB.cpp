#include <iostream>

using namespace std;

int main()
{
int age;
string name, category;

cout << "Please enter your name: \n";
cin >> name;


cout << "Please enter your age: \n";
cin >> age;

if(age<25){ 
   category = "young";
}
else if(age<45){
   category = "mature";
}
else if(age<60){ 
   category = "old";
}
else{ 
   category = "over the hill";
}

cout << name << " is " << age << " and is in the " << category << " group.\n";

return 0;
}

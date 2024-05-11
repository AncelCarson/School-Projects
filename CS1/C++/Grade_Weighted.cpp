// Ancel Carson
// 2/17/17

#include <iostream>
using namespace std;

//Prototype Statements
float grader (float, float, float, float);
char letterGrade (float);

int main ()
{
   float test1, test2, test3, test4, students, grade;
   string first, last;
   char letter;
   cout << "How mant students are in your class?\n";
   cin >> students;
   for (int n=1; n<=students; n++)
   {
      cout << "What is the students's first name?\n";
      cin >> first;
      cout << "What is the students's last name?\n";
      cin >> last;
      cout << "What is the first test score?\n";
      cin >> test1;
      cout << "What is the second test score?\n";
      cin >> test2;
      cout << "What is the third test score?\n";
      cin >> test3;
      cout << "What is the fourth test score?\n";
      cin >> test4;
      grade = grader (test1, test2, test3, test4);
      letter = letterGrade (grade);
      cout << "\n" << last << "," << first << " " << grade << " " << letter << "\n\n";
   }
   return 0;
}

//Finds the weighted grade
float grader (float score1, float score2, float score3, float score4)
{
   float result;
   score1 = score1*20;
   score2 = score2*20;
   score3 = score3*20;
   score4 = score4*40;
   result = (score1+score2+score3+score4)/100;
   return result;
}

//Assigns the letter grade
char letterGrade (float final)
{
   char result;
   if (final < 60)
   {
      result = 'F';
   }
   else if (final < 70)
   {
      result = 'D';
   }
   else if (final < 80)
   {
      result = 'C';
   }
   else if (final < 90)
   {
      result = 'B';
   }
   else
   {
      result = 'A';
   }
   return result;
}
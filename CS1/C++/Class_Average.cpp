// Ancel Carson
// 3/20/17

#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;

//Prototype Statements
float grader (float, float, float, float);
char letterGrade (float);

int main ()
{
   ifstream classGrades;
   ofstream classStatistics;
   classGrades.open("Text Files/ClassScores.txt");
   classStatistics.open("Text Files/classStatistics.txt");
   int numRows = 300, numCols = 4, c, r = 0, countRows = 0;
   int numbers[numRows][numCols];
   float grade1, grade2, grade3, grade4, score [numRows];
   float A = 0, B = 0, C = 0, D = 0, F = 0, students;
   char letter[numRows];
   string className;
   if (!classGrades)
   {
      cerr << "The file did not open.\n";
      return 1;
   }
   cout << "What is the name of your class?\n";
   cin >> className;
   while (!classGrades.eof())
   {
      for (c = 0; c < numCols; c++)
      {
         classGrades >> numbers[countRows][c];
      }
      countRows++;
   }
   for (r = 0; r < countRows; r++)
   {
      grade1 = numbers[r][0];
      grade2 = numbers[r][1];
      grade3 = numbers[r][2];
      grade4 = numbers[r][3];
      score[r] = grader (grade1, grade2, grade3, grade4);
      letter[r] = letterGrade(score[r]);
   }
   for (r = 0; r < countRows; r++)
   {
      if (letter[r]=='A')
      {
         A = A+1;
      }
      else if (letter[r]=='B')
      {
         B = B+1;
      }
      else if (letter[r]=='C')
      {
         C = C+1;
      }
      else if (letter[r]=='D')
      {
         D = D+1;
      }
      else if (letter[r]=='F')
      {
         F = F+1;
      }
   }
   students = A+B+C+D+F;
   cout << className << endl;
   cout << fixed << setprecision(2);
   cout << "\tA's --> " << A << " --> " << (A/students)*100 << "%\n";
   cout << "\tB's --> " << B << " --> " << (B/students)*100 << "%\n";
   cout << "\tC's --> " << C << " --> " << (C/students)*100 << "%\n";
   cout << "\tD's --> " << D << " --> " << (D/students)*100 << "%\n";
   cout << "\tF's --> " << F << " --> " << (F/students)*100 << "%\n";
   classStatistics << className << endl;
   classStatistics << fixed << setprecision(2);
   classStatistics << "\tA's --> " << A << " --> " << (A/students)*100 << "%\n";
   classStatistics << "\tB's --> " << B << " --> " << (B/students)*100 << "%\n";
   classStatistics << "\tC's --> " << C << " --> " << (C/students)*100 << "%\n";
   classStatistics << "\tD's --> " << D << " --> " << (D/students)*100 << "%\n";
   classStatistics << "\tF's --> " << F << " --> " << (F/students)*100 << "%\n";
   classGrades.close();
   classStatistics.close();
   return 0;
}

//Finds the weighted grade
float grader (float score1, float score2, float score3, float score4)
{
   float result;
   score1 = score1*.2;
   score2 = score2*.2;
   score3 = score3*.2;
   score4 = score4*.4;
   result = (score1+score2+score3+score4);
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

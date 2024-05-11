/* Program Written for CSII
   In Class 1
   Program written by Ancel Carson
   22/1/18
   Windows 10
   JGrasp and Command Line
   This program finds the sum of the digits in a number between 0 & 1000
*/

import java.util.Scanner;
public class IntegerSum{
   public static void main(String[] args){

      //Defining variables
      int BeginningNumber = 0, digit1 = 0, digit2 = 0, digit3 = 0, FinalNumber = 0;
      String name;
      Scanner TheInput = new Scanner(System.in);

      //Input statements
      System.out.println("Please enter your first name.");
      name = TheInput.next();
      System.out.println("Please enter an integer between 0 and 1000");
      BeginningNumber = TheInput.nextInt();

      //Calculations
      digit1 = BeginningNumber / 100;
      digit2 = (BeginningNumber - (digit1 * 100)) / 10;
      digit3 = (BeginningNumber - ((digit1 * 100) + (digit2 * 10)));
      FinalNumber = digit1 + digit2 + digit3;

      //Output Statments
      System.out.println(name + " your sum is " + FinalNumber);
   }
}

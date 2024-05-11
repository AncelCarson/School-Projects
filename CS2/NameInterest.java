/* Program Written for CSII
   Assignment 2
   Program written by Ancel Carson
   26/1/18
   Windows 10
   Atom and Command Line
   This program takes the User's first and last name and caculates their interest using
   those inputs and an initial amount
*/

import java.util.Scanner;
public class NameInterest{
   public static void main(String[] args){

      //Variables Declared
      double initialAmount, finalAmount;
      double interestRate, monthlyInterest, interestFun, numMonths;
      float firstCharValue, lastCharValue;
      int numYears;
      String firstName, lastName;
      char firstChar, lastChar;
      Scanner theInput = new Scanner(System.in);

      //Input Statements
      System.out.println("Please enter your first name");
      firstName = theInput.next();
      System.out.println("Please enter your last name");
      lastName = theInput.next();
      System.out.println("Please enter your initial amount");
      initialAmount = theInput.nextDouble();

      //Variable Assigning
      numYears = firstName.length();
      firstChar = firstName.charAt(0);
      lastChar = lastName.charAt(0);
      firstCharValue = (int)firstChar;
      lastCharValue = (int)lastChar;
      if(firstCharValue < lastCharValue){
         interestRate = ((firstCharValue / lastCharValue) * 10);
      }
      else if(firstCharValue > lastCharValue){
         interestRate = ((lastCharValue / firstCharValue) * 10);
      }
      else{
         interestRate = 5;
      }

      //Calculations
      monthlyInterest = 1 + ((interestRate / 100) / 12);
      numMonths = numYears * 12;
      interestFun = Math.pow(monthlyInterest, numMonths);
      finalAmount = initialAmount * interestFun;

      //Output Statements
      System.out.printf("Info for %c%c:\n", firstChar, lastChar);
      System.out.printf("Interest: %.1f%%\n", interestRate);
      System.out.printf("Number of years: %d\n", numYears);
      System.out.printf("Amount: $%,.2f", finalAmount);
   }
}

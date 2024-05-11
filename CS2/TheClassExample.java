/* Program Written for CSII
   In Class 2
   Program written by Ancel Carson
   19/3/18
   Windows 10
   Atom and Command Line
   Program reads a file and converts the information into text for another file
*/

import java.util.Scanner;
import java.io.*; //* means everything in that file
public class TheClassExample{
   public static void main(String[] args)throws IOException{


      //Create a scanner
      File inputFile = new File("Text_Files/Info.txt"); //For in program use / not \
      Scanner input = new Scanner(inputFile);

      //Create PrintWriter
      File outputFile = new File("Text_Files/Results.txt");
      PrintWriter output = new PrintWriter(outputFile);

      //Declare variables
      double interestRate, investmentAmount, futureAmount;
      int years;
      String firstName, lastName;
      char firstInitial, lastInitial;
      boolean check = true; //Always want to initialize

      //Loop defines results for all sets of data in the file
      while (check){
         //Get input
         firstName = input.next();
         lastName = input.next();
         investmentAmount = input.nextDouble();


         // Get initials
         firstInitial = firstName.charAt(0);
         lastInitial = lastName.charAt(0);


         //Calculate values to use in formula
         years = firstName.length();
         if(firstInitial < lastInitial){
            interestRate = ((double)firstInitial/(double)lastInitial/10.0)/12.0;
         }
         else if(lastInitial < firstInitial){
            interestRate = ((double)lastInitial/(double)firstInitial/10.0)/12.0;
         }
         else{
         interestRate = .05/12.0;
         }


         //Calculate the future    using the given formula
         futureAmount = investmentAmount * Math.pow((1 + interestRate),(years*12));


         //Output results.
         output.printf("%c%c %.1f %d %.2f",firstInitial,lastInitial
         ,(interestRate*1200),years,futureAmount);

         /* Could have used
            check = input.hasNext();

            if(check){
               output.println();
            }
         */

         if(input.hasNext()){
            output.println();
         }
         else{
            check = false;
         }
      }

      System.out.println("Program complete. Output is found in File: Text_Files\\Results.txt");

      input.close();
      output.close();
   }
}//End of class

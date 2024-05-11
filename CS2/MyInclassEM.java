/* Program Written for CSII
   In Class 3
   Program written by Ancel Carson
   21/3/18
   Windows 10
   Atom and Command Line
   Program designed to give experience in exceptions
*/

import java.util.Scanner;
import java.util.InputMismatchException; //Accounts for new Exception Type
public class MyInclassEM{
   public static void main(String[] args){

      //Declare Variables
      int num1, num2, result;
      Scanner theInput = new Scanner(System.in);

      try{
         //Input Statements
         System.out.println("Please enter the number of peopple.");
         if(theInput.hasNextInt()){ //Long way to write exeption catch
            num1 = theInput.nextInt();
         }
         else{
            throw new InputMismatchException("You cannot enter part of a person");
         }
         System.out.println("Please enter the number of groups.");
         if(!theInput.hasNextInt()){ //Short way to write exception catch
            throw new InputMismatchException("You cannot enter part of  group");
         }
         num2 = theInput.nextInt();

         //Calculations
         if(num2 == 0){
            throw new ArithmeticException("Sorry, you cannot divide by 0.");
         }
         result = num1 / num2;

         //Output Statements
         System.out.println("The result is " + result);
      }

      catch(ArithmeticException e1){
         // System.out.println("I'm in e1 catch block");
         System.out.println(e1.getMessage());
         //output without getMessage: java.lang.ArithmeticException: Sorry, you cannot divide by 0.
         //output with getMessage: Sorry, you cannot divide by 0.
      }

      catch(InputMismatchException e2){
         System.out.println(e2.getMessage());
      }
   }
}

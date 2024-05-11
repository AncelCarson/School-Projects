/* Program Written for CSII
   Assignment 8
   Program written by Ancel Carson
   2/4/18
   Windows 10
   Atom and Command Line
   Brief Program Description expected input, output, and process
*/

import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;
public class HandelingExceptions{
   public static void main(String[] args){

      //Declare Variables
      int choice, failChoice;
      Scanner theInput = new Scanner(System.in);

      //Input Statements
      menu();
      System.out.println("Choose an option from the menu");
      choice = theInput.nextInt();
      while(true){

         try{
            switch(choice){
               case 1: FailedExceptions.AIOOBE(); break;
               case 2: FailedExceptions.FNFE(); break;
               case 3: FailedExceptions.IME(); break;
               case 4: FailedExceptions.CNFE(); break;
               case 5: FailedExceptions.OOME(); break;
               case 6: FailedExceptions.NSME(); break;
               case 7:
                  System.out.println("Program complete.");
                  System.exit(0);
            }
         }
         catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("Error: Array location does not exist.");
            System.out.println();
         }
         catch(FileNotFoundException e2){
            System.out.println("Error: File does not exist");
            System.out.println();
         }
         catch(InputMismatchException e3){
            System.out.println("Error: Data types do not match.");
            System.out.println();
         }
         catch(ClassNotFoundException e4){
            System.out.println("Error: Class cannot be found.");
            System.out.println();
         }
         catch(OutOfMemoryError e5){
            System.out.println("Error: Array to large.");
            System.out.println();
         }
         catch(NoSuchMethodException e6){
            System.out.println("Error: Method does not exist");
            System.out.println();
         }
         System.out.print("Please make another choice. If you wish to see the menu ");
         System.out.println("again enter 8.");
         choice = theInput.nextInt();
         if (choice == 8){
            menu();
            System.out.println("Choose an option from the menu");
            choice = theInput.nextInt();
         }
      }

      //Calculations

      //Output Statements
   }
   //Menu Method
   public static void menu(){
      System.out.println("|-----------------------------------|");
      System.out.println("| 1: ArrayIndexOutOfBoundsException |");
      System.out.println("| 2: FileNotFoundException          |");
      System.out.println("| 3: InputMismatchException         |");
      System.out.println("| 4: ClassNotFoundException         |");
      System.out.println("| 5: OutOfMemoryError               |");
      System.out.println("| 6: NoSuchMethodException          |");
      System.out.println("| 7: Exit Program                   |");
      System.out.println("|-----------------------------------|");
   }
}

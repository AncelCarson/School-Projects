/* Program Written for CSII
   Assignment 8
   Program written by Ancel Carson
   23/4/18
   Windows 10
   Atom and Command Line
   Program contains methods for HandelingExceptions file.
*/

import java.util.Scanner;
import java.io.*;
import java.lang.Class;
public class FailedExceptions{

   //Global variables
   static int choice;

   public static void AIOOBE(){
      int arrayNum, arrayChoice, myNum;
      int[] myArray;
      Scanner theInput = new Scanner(System.in);

      System.out.println("Would you like to correctly run the code or cause an error?");
      System.out.println("To correctly run the code enter 1");
      System.out.println("To cause an error, enter 0");
      choice = theInput.nextInt();
      System.out.print("\nAn ArrayIndexOutOfBoundsException is thrown whenever an array ");
      System.out.println("block, that does not exist, is called.");
      System.out.println("Please enter a number 1-10");
      arrayNum = theInput.nextInt();
      myArray = new int[arrayNum];
      for (int i = 0; i < arrayNum; i++){
         myArray[i] = i + 1;
      }
      System.out.printf("\nAn array called myArray has just been created with %d", arrayNum);
      System.out.printf(" boxes. Each numbered 1-%d.\n\n", arrayNum);
      System.out.println("Arrays are numbered differently from counting standards.");
      System.out.print("Because of this box 1 is actually numbered 0 and ");
      System.out.printf("box %d is %d\n\n", arrayNum, arrayNum - 1);
      if (choice == 1){
         System.out.println("Here is an example to illistrate this idea.");
         System.out.printf("Please enter a number between 0 and %d\n", arrayNum - 1);
         arrayChoice = theInput.nextInt();
         System.out.printf("\nThe number you just entered goes into a line of code that ");
         System.out.printf("looks like this \"System.out.println(myArray[%d])\"\n\n", arrayChoice);
         System.out.println(myArray[arrayChoice]);
         System.out.printf("This answer was output because the box accessed was number ");
         System.out.printf("%d even though the number you put in ", arrayChoice + 1);
         System.out.printf("was %d\n\n", arrayChoice);
      }
      else{
         System.out.printf("To cause an exception, you are going to call a box that ");
         System.out.printf("does not exist in the array.\n");
         System.out.printf("To do this please enter a number greater than %d\n", arrayNum - 1);
         arrayChoice = theInput.nextInt();
         System.out.println("Now enter a value to put in the block.");
         myNum = theInput.nextInt();
         System.out.printf("\nThe numbers you just entered goes into a line of code that ");
         System.out.printf("looks like this \"myArray[arrayChoice] = myNum;\"\n", arrayChoice);
         System.out.printf("This throws the following exception:\n");
         myArray[arrayChoice] = myNum;
      }
   }

   public static void FNFE()throws FileNotFoundException{
      File testFile = new File("Text_Files/ExceptionFile.txt");
      File readFile;
      Scanner fileScanner;
      PrintWriter output = new PrintWriter(testFile);
      String fileName;
      Scanner theInput = new Scanner(System.in);

      System.out.println("Would you like to correctly run the code or cause an error?");
      System.out.println("To correctly run the code enter 1");
      System.out.println("To cause an error, enter 0");
      choice = theInput.nextInt();
      System.out.print("A FileNotFoundException is thrown whenever a file that does not");
      System.out.println(" exist is called.\n");
      System.out.println("This can occure in a code like this:");
      System.out.println("readFile = new File(fileName);\nfileScanner = new Scanner(readFile);\n");
      if (choice == 1){
         System.out.printf("A file called ExceptionFile.txt has been created in the same");
         System.out.printf(" folder as this porgram.\n\n");
         output.close();
         System.out.print("Copy and paste to enter the following file name to access the file");
         System.out.println("\nText_Files\\ExceptionFile.txt");
         fileName= theInput.next();
         readFile = new File(fileName);
         fileScanner = new Scanner(readFile);
         System.out.println("\nThe file does exist so the exception does not occure\n");
      }
      else{
         System.out.print("To cause an exption, copy and paste the following file name");
         System.out.println("\nNoFileHere.txt");
         fileName= theInput.next();
         System.out.println("\nThis causes the exception:");
         readFile = new File(fileName);
         fileScanner = new Scanner(readFile);
      }
   }

   public static void IME(){
      int myNum = 0;
      Scanner theInput = new Scanner(System.in);

      System.out.println("Would you like to correctly run the code or cause an error?");
      System.out.println("To correctly run the code enter 1");
      System.out.println("To cause an error, enter 0");
      choice = theInput.nextInt();
      System.out.print("\nAn InputMismatchException occurs when the wrong type of data");
      System.out.println(" is entered");
      System.out.println("The following is expecting the number 2\n");
      System.out.println("The number is put into a line of code that looks like this:");
      System.out.println("myNum = theInput.nextInt();");
      if (choice == 1){
         System.out.println("The correct input would be to enter \"2\". Do so now");
         myNum = theInput.nextInt();
         System.out.println("The exception is not thrown because the data types match\n");
      }
      else{
         System.out.print("The incorrect input would be to enter \"two\" ");
         System.out.println("causing an exception. Do so now.");
         myNum = theInput.nextInt();
      }
   }

   public static void CNFE()throws ClassNotFoundException{
      Scanner theInput = new Scanner(System.in);
      String classFile;

      System.out.println("Would you like to correctly run the code or cause an error?");
      System.out.println("To correctly run the code enter 1");
      System.out.println("To cause an error, enter 0");
      choice = theInput.nextInt();
      System.out.print("\nA ClassNotFoundException occurs when the program attempts to");
      System.out.println(" access a class that does not exist during runtime.");
      System.out.println("The code to do this looks like this \"Class.forName(classFile)\".\n");
      if (choice == 1){
         System.out.print("To show an example of the correct application copy and paste");
         System.out.println(" the following program name:\nHandelingExceptions");
         classFile = theInput.next();
         Class.forName(classFile);
         System.out.printf("\nThe class was loaded succesfully and no exception was thrown\n\n");
      }
      else{
         System.out.print("To show an example of an incorrect application copy and paste");
         System.out.println(" the following program name:\nNoFileHere");
         classFile = theInput.next();
         System.out.println("\nThis will cause the following exception:");
         Class.forName(classFile);
      }
   }

   public static void OOME(){
      long[] myArray;
      int value;
      Scanner theInput = new Scanner(System.in);

      System.out.println("Would you like to correctly run the code or cause an error?");
      System.out.println("To correctly run the code enter 1");
      System.out.println("To cause an error, enter 0");
      choice = theInput.nextInt();
      System.out.print("\nAn OutOfMemoryError occurs when Java does not have enough ");
      System.out.println("space to create new Threads");
      System.out.println("This can be most easily demonstrated using an array.");
      if (choice == 1){
         System.out.println("To avoid an error, enter a number lower than 8.");
         System.out.println("This will make 10^value array boxes");
         value = theInput.nextInt();
         myArray = new long[(int)Math.pow(10,value)];
         System.out.printf("\nThe program now has an array with %d boxes.\n", (int)Math.pow(10,value));
         System.out.println("Because the number fits within the range there is no error.\n");
      }
      else{
         System.out.println("\nAn error occurs when the number of threads is too large.");
         System.out.println("Too show this, the enter a number larger than than 15.");
         System.out.println("This will make 10^value array boxes");
         value = theInput.nextInt();
         System.out.println("\nBecause the value is too large, an error will be thrown.");
         myArray = new long[(int)Math.pow(10,value)];
      }
   }

   public static void NSME()throws NoSuchMethodException{
      String methodName;
      Scanner theInput = new Scanner(System.in);
      HandelingExceptions test = new HandelingExceptions();
      Class<?> TempClass = test.getClass();

      System.out.println("Would you like to correctly run the code or cause an error?");
      System.out.println("To correctly run the code enter 1");
      System.out.println("To cause an error, enter 0");
      choice = theInput.nextInt();
      System.out.print("\nA ClassNotFoundException occurs when the program attempts to");
      System.out.println(" access a method that does not exist during runtime.");
      System.out.print("The code to do this looks like this ");
      System.out.println("\"TempClass.getMethod(methodName)\".\n");
      if (choice == 1){
         System.out.println("To properly run this the method must exist.");
         System.out.println("Please call the method \"menu\" by entering its name now");
         methodName = theInput.next();
         TempClass.getMethod(methodName);
         System.out.println("Because the metod exists, there is no error.\n");
      }
      else{
         System.out.println("To cause an exception, the method must not exist.");
         System.out.println("Enter anything other than \"menu\" or \"main\" now");
         methodName = theInput.next();
         System.out.println("\nThis causes the Exception.");
         TempClass.getMethod(methodName);
      }
   }
}

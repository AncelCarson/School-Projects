/**
*  @author Ancel Carson
*  Assignment 1
*  25/9/18
*  Total Time Worked: 3:40
*  Windows 10
*  Atom and Command Line
*  Take in a file and output all of the positive or negative numbers
*  based on the users choice.
*/

import java.util.Scanner;
import java.io.*;
public class NumberSort{
   /**
   * Main Controlling Method
   * @param choice                  write positive or negative
   * @param writeLoop               number of times writing loop runs
   * @param startArrayLength        number of integers read from file
   * @param endArrayLength          number of integers written to file
   * @param outFileName             name of file being written to
   * @param inputNums               array to hold integers from given file
   * @param outputNums              array to hold integers being written
   * @param inputFile               file that integers are being red from
   * @param outputFile              file that integers are written to
   * @param fileScanner             scanner for input file
   * @param theInput                scanner to take user input
   * @param output                  printwriter that writes to new file
   * @param check                   boolean to controll writing loop
   * @throws ArithmeticException    ensures a file is given
   * @throws FileNotFoundException  ensures file given exists
   */
   public static void main(String[] args){
      //Declare Variables
      int choice, writeLoop = 0, startArrayLength = 0, endArrayLength = 0;
      String outFileName = null;
      int[] inputNums = new int[6000], outputNums = new int[6000];
      File inputFile, outputFile;
      Scanner fileScanner = null, theInput = new Scanner(System.in);
      PrintWriter output = null;
      boolean check = true;

      //Input Statements
      try{
         if(args.length != 1){
            throw new ArithmeticException();
         }
         inputFile = new File(args[0]);
         fileScanner = new Scanner(inputFile);
         outFileName = getName();
         outputFile = new File(outFileName);
         output = new PrintWriter(outputFile);
      }
      catch(ArithmeticException e1){
         System.out.println("You must input one file.\n");
         System.exit(0);
      }
      catch(FileNotFoundException e2){
         System.out.println("Error: File does not exist\n");
         System.exit(0);
      }

      //Takes integers from file and places them in the starting array
      while(fileScanner.hasNext()){
         inputNums[startArrayLength] = fileScanner.nextInt();
         startArrayLength++;
      }

      //Requests the user to choose positive or negative numbers
      System.out.println("Which set of numbers do you want?");
      System.out.println("For positive numbers enter 0");
      System.out.println("For negative numbers enter 1");
      choice = theInput.nextInt();

      //Calculations

      //Calls filtering method
      endArrayLength = sortNums(inputNums, outputNums, choice, startArrayLength);

      while(check){
         output.print(outputNums[writeLoop]);
         if(writeLoop < endArrayLength - 1){
            output.println();
         }
         else{
            check = false;
         }
         writeLoop++;
      }

      //Output Statements
      //Tells user file name and number of integers in both files
      System.out.println("The program has been completed");
      System.out.printf("Youre file name is %s.\n", outFileName);
      System.out.printf("The original file had %d integers ", startArrayLength);
      System.out.printf("and the new file has %d integers.\n", endArrayLength);

      output.close();
      fileScanner.close();
      theInput.close();
   }

   /**
   * Gets name from user to create output file name
   * @param firstName      first name of user
   * @param lastName       last name of user
   * @param fileName       name of file to write to
   * @param methodInput    scanner for user input within method
   * @return               name of file to write to
   */
   public static String getName(){
      String firstName, lastName, fileName;
      Scanner methodInput = new Scanner(System.in);

      System.out.println("Please enter your first name.");
      firstName = methodInput.next();
      System.out.println("Please enter your last name.");
      lastName = methodInput.next();

      fileName = firstName + lastName + "Numbers.txt";
      methodInput.close();
      return fileName;
   }

   /**
   * Selects even or odd numbers from the starting array
   * This depends on the users choice
   * Returns new array with selected values
   * @param inputNums         array to hold integers from given file
   * @param outputNums        array to hold filtered integers
   * @param choice            user's choice tht control filtering
   * @param startArrayLength  number of relevant integers in inputNums
   * @param multiplier        number that filters positive or negative
   * @param j                 number of relevant integers in outputNums
   * @return                  number of relevant integers in outputNums
   */
   public static int sortNums(int[] inputNums, int[] outputNums, int choice, int startArrayLength){
      int multiplier = 0, j = 0;

      switch(choice){
         case 0: multiplier = 1; break;
         case 1: multiplier = -1; break;
      }
      // Writes appropriate numbers to output array
      for (int i = 0; i < startArrayLength; i++){
         if((inputNums[i] * multiplier) > 0){
            outputNums[j] = inputNums[i];
            j++;
         }
      }
      return j;
   }
}
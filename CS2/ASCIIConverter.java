/* Program Written for CSII
   Assignment 3
   Program written by Ancel Carson
   12/2/18
   Windows 10
   Atom and Command Line
   This program takes in a varied number of ASCII values and outputs a single word with
   the correct conversions.
*/

import java.util.Scanner;
public class ASCIIConverter{
   public static void main(String[] args){

      //Declare Variables
      int numChar = 0, charVal = 0;
      String phrase = " ", currentString, trimPhrase;
      char currentChar;
      Scanner theInput = new Scanner(System.in);


      //Input Statements
      System.out.printf("How many letters are in your phrase?\n");
      numChar = theInput.nextInt();
      System.out.printf("To use the ASCII Table join the number in the column on the ");
      System.out.printf("left and the number along the top that corresponds to your ");
      System.out.printf("character of choice.\nExample: A = (6+5) = 65\n");
      ASCIITable();

      //Converter and Compiler
      for (int i = 1; i <= numChar; i++){
         System.out.printf("Please enter value number %d\n",i);
         charVal = theInput.nextInt();
         currentChar = (char)charVal;
         phrase = phrase + currentChar;
      }
      trimPhrase = phrase.trim();

      //Output Statement
      System.out.printf("%s",trimPhrase);
   }

   //Prints the ASCII Table ! to ~
   public static void ASCIITable(){
      char character;
      int val;
      System.out.println("    |  0  1  2  3  4  5  6  7  8  9");
      System.out.println(" -  +  -  -  -  -  -  -  -  -  -  -");
      for (int i = 3; i <= 12; i++){
         if (i < 10){
            System.out.printf(" ");
         }
         System.out.printf("%d  |",i);
         for (int j = 0; j <= 9; j++){
            if ((i * 10) + j < 33){
               System.out.printf("   ");
               continue;
            }
            if ((i * 10) + j > 126){
               System.out.printf("   ");
               continue;
            }
            val = (i * 10) + j;
            character = (char)val;
            System.out.printf("  %c",character);
         }
         System.out.printf("\n");
      }
   }
}

/**
*  @author Ancel Carson
*  Assignment 11
*  30/10/18
*  Total Time Worked: 1:00
*  Windows 10
*  Atom and Command Line
*  Program reads in a file and outputs the the number of occurances for each letter to another file
*/

import java.util.Scanner;
import java.io.*;
public class CharacterCount{

   /**
   * Main method that runs program
   * @param args     String taken in from the command line
   */
   public static void main(String[] args){

      //Declare Variables
      int upperLimitChar = 0,          //Number of occurances for previous charaacter
         currentMaxChar = 0,           //Highest number of occurances in current loop
         printIndex = 0,               //Index of character with most occurances but less than printed index
         printedIndex = 0;             //Index of character that was printed before the loop ran again
      int[] charArray = new int[27];   //Array that holds number of occurances per character
      String myString;                 //Sentence that character occurances are being checked from
      File inputFile = null;           //File given by user
      File outputFile = null;          //File where output is written
      Scanner theInput = null;         //Takes input from given file
      PrintWriter theOutput = null;    //Writes to output file

      //Makes sure file was entered properly
      if(args.length != 1){
         System.out.println("You put input a single file");
         System.exit(1);
      }
      try{
         inputFile = new File(args[0]);
         theInput = new Scanner(inputFile).useDelimiter("\\.");;
         outputFile = new File("Text_Files/character_count.txt");
         theOutput = new PrintWriter(outputFile);
      }
      catch(FileNotFoundException e1){
         System.out.println("The given file does not exist");
         System.exit(1);
      }

      //Runs as long as there is more data in given file
      while (theInput.hasNext()){
         myString = theInput.next();
         for (char c : myString.toCharArray()){
            findCharacter(c, charArray);     //Calls method that increases occurance per character
         }
      }

      //Runs for a number of times equal to the number of characters
      for(int i = 0; i <= 26; i++){

         //Checks each box of the array per loop
         for(int j = 0; j <= 26; j++){

            //Handles condition where upperLimitChar has not yet been defined
            if(i == 0){

               //Finds the character that has occured the most
               if(currentMaxChar < charArray[j]){
                  currentMaxChar = charArray[j];
                  printIndex = j;
               }
            }
            else{

               //Finds character that has occured the most but is also less than the last character
               if(currentMaxChar <= charArray[j] && charArray[j] < upperLimitChar){
                  currentMaxChar = charArray[j];
                  printIndex = j;
               }

               //handles if a character has occured the same number of time as another character
               if(charArray[j] == upperLimitChar && j < printedIndex){
                  printIndex = j;
                  currentMaxChar = charArray[j];
               }
            }
         }
         upperLimitChar = currentMaxChar;
         currentMaxChar = 0;
         printedIndex = printIndex;

         //Outputs to file the character that has occured the most but less that previous
         //and number of occurances
         if(printIndex == 0){
            theOutput.printf("Space %d", charArray[0]);
         }
         else{
            theOutput.printf("%c %d", (char)(printIndex + 96), charArray[printIndex]);
         }
         if(i != 26){
            theOutput.println();
         }
      }

      //Outputs what prgram has ended
      System.out.println("The program has completed, the file can be found at TextFiles\\character_count.txt");
      theInput.close();
      theOutput.close();
   }

   /**
   * Method that increases occurance value that corelates to the character it was sent
   * @param c              //Character that was taken from the sentence
   * @param charString     //Array that holds the occurances per character
   */
   static void findCharacter(char c, int[] charString){
      int charVal = (int)c;

      //Converts capitals to lower case
      if(charVal >= 65 && charVal <= 90){
         charVal = charVal + 32;
      }

      //Increases occurance if the character is a space
      if(charVal == 32){
         charString[0]++;
      }

      //Increases the occurance of a lower case letter
      if(charVal >= 97 && charVal <= 122){
         charString[charVal - 96]++;
      }
   }
}
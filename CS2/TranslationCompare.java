/* Program Written for CSII
   Assignment 7
   Program written by Ancel Carson
   27/3/18
   Windows 10
   Atom and Command Line
   This program takes three files and outputs the number or sentences, words, and
   characters of those files in a separate file
*/

import java.util.Scanner;
import java.io.*;
public class TranslationCompare{
   public static void main(String[] args)throws IOException{

      //Declare Variables
      String sentence, translation;
      int wordLength, charSentence, sentenceLength;
      int numChars, numWords, numSentences;
      Scanner[] input = new Scanner[3];
      File[] file = new File[3];
      File outputFile = new File("Text_Files/CompareInfo.txt");
      PrintWriter output = new PrintWriter(outputFile);

      //Checks to ensure there are treee files to input
      try{
         if(args.length != 3){
            throw new ArithmeticException("You must have three files.");
         }
         for(int i = 0; i < 3; i++){
            file[i] = new File(args[i]);
            input[i] = new Scanner(file[i]).useDelimiter("\\n");
         }
      }
      catch(ArithmeticException e1){
         System.out.println(e1.getMessage());
         System.exit(0);
      }

      output.println("Statistics for the first chapter of James:");
      output.println();

      for(int i = 0; i < 3; i++){
         translation = input[i].next();
         input[i].useDelimiter("\\.");
         numChars = 0;
         numWords = 0;
         numSentences = 0;
         while(input[i].hasNext()){
            sentence = input[i].next();
            for(String word: sentence.split("\\s")){
               wordLength = word.length();
               numChars = numChars + wordLength + 1;
               numWords++;
            }
            numWords--;
            numSentences++;
         }
         numChars--;
         output.println(translation);
         output.println("Characters: " + numChars);
         output.println("Words: " + numWords);
         output.print("Sentences: " + numSentences);
         if(i < 2){
            output.printf("\n\n\n");
         }
      }

      System.out.println("Program complete. Output is found in File: Text_Files\\CompareInfo.txt");
      output.close();
   }
}

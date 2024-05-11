/* Program Written for CSII
   Assignment 9
   Program written by Ancel Carson
   11/4/18
   Windows 10
   Atom and Command Line
   This program takes in a large file of numbers, puts them in an array, and sorts them.
   The time needed to do the last two actions is written to a file.
*/

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;
public class DataSorter{
   public static void main(String[] args){

      //Declare Variables
      int count = 0;
      int[] nums = new int[2500000];
      StopWatch loadTime =  new StopWatch();
      StopWatch sortTime = new StopWatch();
      File inputFile = new File ("bigDataLarge.txt");
      File outputFile = new File ("TimeResults.txt");
      Scanner theInput = null;
      Scanner checker = null;
      FileWriter fr = null;
      BufferedWriter br = null;
      PrintWriter output = null;

      try{
         theInput = new Scanner(inputFile);
         checker = new Scanner(outputFile);
         fr = new FileWriter(outputFile, true);
         br = new BufferedWriter(fr);
         output = new PrintWriter(br);
      }
      catch(IOException e1){
         System.out.println("File missing, Please add file to folder and rerun program.");
         System.exit(0);
      }

      //Load the numbers into an array
      loadTime.start();
      while(true){
         if(!theInput.hasNext()){
            break;
         }
         nums[count] = theInput.nextInt();
         count++;
      }
      loadTime.stop();

      //Sort the array from smallest to largest
      sortTime.start();
      Arrays.sort(nums);
      sortTime.stop();

      //Output Statements
      if(outputFile.length() != 0){
         output.println();
         output.println();
      }
      output.println(loadTime.getElapsedTime());
      output.print(sortTime.getElapsedTime());
      System.out.println("Program is complete");

      output.close();
   }
}

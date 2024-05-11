/**
*  @author Ancel Carson
*  Assignment 3
*  17/9/18
*  Total Time Worked: 45 min
*  Windows 10
*  Atom and Command Line
*  Brief Program Description expected input, output, and process
*/

import java.util.*;
import java.io.*;
public class ListTypeDriver{
   /**
   * Main driving array that runs the different data structures
   * @param counter                 Integer that counts where in the normal array to add value
   * @param minutes                 Integer that holds how many minutes have passes for each list
   * @param milliseconds            Integer that holds how many milliseconds from timer object
   * @param seconds                 Integer that holds how many seconds have passes for each list
   * @param simpleArray             Integer array that holds input data
   * @param myArrayList             ArrayList that holds input data
   * @param myLinkedList            LinkedList that holds input data
   * @param myBackwardsArrayList    BackwardsArrayList that holds input data
   * @param timer                   StopWatch that counts time elapsed from system time
   * @param inputFile               File array that holds file from command prompt
   * @param inputScanner            Scanner array that reads files from inputFile
   * @throws FileNotFoundException  Maks sure file is given
   */
   public static void main(String[] args){

      //Declare Variables
      int counter = 0;
      long minutes = 0, milliseconds = 0;
      double seconds = 0;
      int[] simpleArray = new int[2500000];
      List<Integer> myArrayList = new ArrayList<Integer>();
      LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
      BackwardArrayList myBackwardsArrayList = new BackwardArrayList();
      StopWatch timer = new StopWatch();
      File[] inputFile = new File[4];
      Scanner[] inputScanner = new Scanner[4];

      //Checks that a file was given
      if(args.length != 1){
         System.out.println("You must include one file.");
         System.exit(1);
      }

      //Makes sure given files exist
      try{
         for(int i = 0; i < 4; i++){
            inputFile[i] = new File(args[0]);
            inputScanner[i] = new Scanner(inputFile[i]);
         }
      }
      catch(FileNotFoundException e1){
         System.out.println("File specified could not be found.");
         System.exit(1);
      }

      //Filling the simple array
      timer.start();
      while(inputScanner[0].hasNext()){
         simpleArray[counter] = inputScanner[0].nextInt();
         counter++;
      }
      timer.stop();
      milliseconds = timer.getElapsedTime();
      seconds = (double)milliseconds / 1000;
      minutes = (long)seconds / 60;
      seconds = (seconds - (minutes * 60));
      System.out.print("Time to complete simple array transfer was ");
      System.out.printf("%d minutes and %.2f seconds.\n", minutes, seconds);

      //Fillng the ArrayList
      timer.start();
      while(inputScanner[1].hasNext()){
         myArrayList.add(inputScanner[1].nextInt());
      }
      timer.stop();
      milliseconds = timer.getElapsedTime();
      seconds = (double)milliseconds / 1000;
      minutes = (long)seconds / 60;
      seconds = (seconds - (minutes * 60));
      System.out.print("Time to complete array list transfer was ");
      System.out.printf("%d minutes and %.2f seconds.\n", minutes, seconds);

      //Filling the LinkedList
      timer.start();
      while(inputScanner[2].hasNext()){
         myLinkedList.add(inputScanner[2].nextInt());
      }
      timer.stop();
      milliseconds = timer.getElapsedTime();
      seconds = (double)milliseconds / 1000;
      minutes = (long)seconds / 60;
      seconds = (seconds - (minutes * 60));
      System.out.print("Time to complete linked list transfer was ");
      System.out.printf("%d minutes and %.2f seconds.\n", minutes, seconds);

      //Filling the BackwardsArrayList
      timer.start();
      while(inputScanner[3].hasNext()){
         myBackwardsArrayList.addSomething(inputScanner[3].nextInt());
      }
      timer.stop();
      milliseconds = timer.getElapsedTime();
      seconds = (double)milliseconds / 1000;
      minutes = (long)seconds / 60;
      seconds = (seconds - (minutes * 60));
      System.out.print("Time to complete array list transfer was ");
      System.out.printf("%d minutes and %.2f seconds.\n", minutes, seconds);
   }
}

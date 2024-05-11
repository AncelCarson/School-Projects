/**
*  @author Ancel Carson
*  Assignment 9
*  26/10/18
*  Total Time Worked: 2:10
*  Windows 10
*  Atom and Command Line
*  This program runs 10 different cases through hash tables and places them
*  inside a circular array
*/

import java.util.Scanner;
import java.io.*;
public class HashCase{

   /**
   * Main driving method of the class
   * @param args     String that is sent from command line
   */
   public static void main(String[] args){

      //Variable Declarations
      String[] names = new String[175];
      File inputFile = null;
      Scanner fileInput = null;

      //Makes sure a file was given
      if(args.length != 1){
         System.out.println("You must input 1 file when starting the program");
         System.exit(1);
      }

      //Makes sure that the given file exists
      try{
         inputFile = new File(args[0]);
         fileInput = new Scanner(inputFile).useDelimiter("\\n");
      }
      catch(FileNotFoundException e1){
         System.out.println("Your must enter a valid file");
         System.exit(1);
      }

      //Fills array with names
      for(int i = 0; i < 175; i++){
         names[i] = fileInput.next();
      }

      //Calls method for each individual case
      case1(names);
      case2(names);
      case3(names);
      case4(names);
      case5(names);
      case6(names);
      case7(names);
      case8(names);
      case9(names);
      case10(names);

      //Closing scanner
      fileInput.close();
   }

   /**
   * Method that drives case 1
   * @param names    String array that containes the names from the file
   */
   static void case1(String[] names){

      //Creation of circular array
      MyCircularArray array1 = new MyCircularArray(1, 175);

      //Places the name is the array based off the hash function
      addCase(1, names, array1);

      //Outputs the number of collisions in case 1
      System.out.printf("case 1: %d collisions\n", array1.getCollisions());
   }

   /**
   * Method that drives case 12
   * @param names    String array that containes the names from the file
   */
   static void case2(String[] names){

      //Creation of circular array
      MyCircularArray array2 = new MyCircularArray(2, 175);

      //Places the name is the array based off the hash function
      addCase(2, names, array2);

      //Outputs the number of collisions in case 2
      System.out.printf("case 2: %d collisions\n", array2.getCollisions());
   }

   /**
   * Method that drives case 3
   * @param names    String array that containes the names from the file
   */
   static void case3(String[] names){

      //Creation of circular array
      MyCircularArray array3 = new MyCircularArray(1, 350);

      //Places the name is the array based off the hash function
      addCase(1, names, array3);

      //Outputs the number of collisions in case 3
      System.out.printf("case 3: %d collisions\n", array3.getCollisions());
   }

   /**
   * Method that drives case 4
   * @param names    String array that containes the names from the file
   */
   static void case4(String[] names){

      //Creation of circular array
      MyCircularArray array4 = new MyCircularArray(2, 350);

      //Places the name is the array based off the hash function
      addCase(2, names, array4);

      //Outputs the number of collisions in case 4
      System.out.printf("case 4: %d collisions\n", array4.getCollisions());
   }

   /**
   * Method that drives case 5
   * @param names    String array that containes the names from the file
   */
   static void case5(String[] names){

      //Creation of circular array
      MyCircularArray array5 = new MyCircularArray(2, 175, 60);

      //Places the name is the array based off the hash function
      addCase(2, names, array5);

      //Outputs the number of collisions in case 5
      System.out.printf("case 5: %d collisions\n", array5.getCollisions());
      System.out.println("\tUsed 60% as fill percentage");
   }

   /**
   * Method that drives case 6
   * @param names    String array that containes the names from the file
   */
   static void case6(String[] names){

      //Creation of circular array
      MyCircularArray array6 = new MyCircularArray(2, 175, 61);

      //Places the name is the array based off the hash function
      addCase(2, names, array6);

      //Outputs the number of collisions in case 6
      System.out.printf("case 6: %d collisions\n", array6.getCollisions());
      System.out.println("\tUsed 61% as fill percentage");
   }

   /**
   * Method that drives case 7
   * @param names    String array that containes the names from the file
   */
   static void case7(String[] names){

      //Creation of circular array
      MyCircularArray array7 = new MyCircularArray(3, 175);

      //Places the name is the array based off the hash function
      addCase(3, names, array7);

      //Outputs the number of collisions in case 7
      System.out.printf("case 7: %d collisions\n", array7.getCollisions());
   }

   /**
   * Method that drives case 8
   * @param names    String array that containes the names from the file
   */
   static void case8(String[] names){

      //Creation of circular array
      MyCircularArray array8 = new MyCircularArray(1, 10, true);

      //Places the name is the array based off the hash function
      addCase(1, names, array8);

      //Outputs the size of each bucket in case 8
      System.out.println("Case 8:");
      array8.getBuckets();
   }

   /**
   * Method that drives case 9
   * @param names    String array that containes the names from the file
   */
   static void case9(String[] names){

      //Creation of circular array
      MyCircularArray array9 = new MyCircularArray(2, 10, true);

      //Places the name is the array based off the hash function
      addCase(2, names, array9);

      //Outputs the size of each bucket in case 9
      System.out.println("Case 9:");
      array9.getBuckets();
   }

   /**
   * Method that drives case 10
   * @param names    String array that containes the names from the file
   */
   static void case10(String[] names){

      //Creation of circular array
      MyCircularArray array10 = new MyCircularArray(2, 20, true);

      //Places the name is the array based off the hash function
      addCase(2, names, array10);

      //Outputs the size of each bucket in case 10
      System.out.println("Case 10:");
      array10.getBuckets();
   }

   /**
   * Method that calls correct hash table and adds vaule to the circular array
   * @param hashChoice  Integer value that controls which hash teble to use
   * @param names       String array that containes the names from the file
   * @param myArray     Circular Array where names will be put
   */
   static void addCase(int hashChoice, String[] names, MyCircularArray myArray){
      int hashIndex = 0;      //Controling variable for which hash table to use

      //Runs for the length of the names array
      for(int i = 0; i < names.length; i++){

         //Selects desired hash function and adds it to the circular array
         switch(hashChoice){
            case 1:
               hashIndex = ASCIIHash(names[i], myArray.getLength());
               myArray.add(hashIndex, names[i]);
               break;
            case 2:
               hashIndex = bookHash(names[i], myArray.getLength());
               myArray.add(hashIndex, names[i]);
               break;
            case 3:
               hashIndex = myHash(names[i], myArray.getLength());
               myArray.add(hashIndex, names[i]);
               break;
         }
      }
   }

   /**
   * Method that uses ASCII addition
   * @param name           Name to be added to the Circular Array
   * @param arrayLength    Length of the Circuar Array
   * @return               Index of where wht name will be stored
   */
   static int ASCIIHash(String name, int arrayLength){
      long hash = 0;       //Value that holds result of caltulation

      //Runs for length of the name
      for(int i = 0; i < name.length(); i++){

         //Hash function
         hash = hash + (int)name.charAt(i);
      }
      return (int)(hash % arrayLength);
   }

   /**
   * Method that uses polynomial hash code
   * @param name           Name to be added to the Circular Array
   * @param arrayLength    Length of the Circuar Array
   * @return               Index of where wht name will be stored
   */
   static int bookHash(String name, int arrayLength){
      long hash = 0;       //Value that holds result of caltulation

      //Runs for length of the name
      for(int i = 0; i < name.length(); i++){

         //Hash function
         hash = 31 * hash + (int)name.charAt(i);
      }
      return (int)(hash % arrayLength);
   }

   /**
   * Method that uses my hash function
   * @param name           Name to be added to the Circular Array
   * @param arrayLength    Length of the Circuar Array
   * @return               Index of where wht name will be stored
   */
   static int myHash(String name, int arrayLength){
      long hash = 0;       //Value that holds result of caltulation

      //Runs for length of the name
      for(int i = 0; i < name.length(); i++){

         //Hash function
         hash = 47 * hash + (int)name.charAt(i);
      }
      return (int)(hash % arrayLength);
   }
}
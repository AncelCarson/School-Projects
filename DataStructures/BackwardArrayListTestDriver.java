/**
*  @author Ancel Carson
*  Assignment 2
*  6/9/18
*  Total Time Worked: 2:55
*  Windows 10
*  Atom and Command Line
*  Test program for BackwardArrayList class
*/


public class BackwardArrayListTestDriver{
   /**
   * Main method that runs through the different operations of the BackwardArrayList class
   * @param foundLocation  location of requested integer returned from BackwardArrayList
   * @param addState       Boolean for if an integer was successfully added to the list
   * @param removeState    Boolean for if an integer was successfully removed from the list
   * @param testList       Object from BackwardArrayList class acting as an arrayList
   */
   public static void main(String[] args){

      //Declare Variables
      int foundLocation = 0;
      boolean addState = true, removeState = true;
      BackwardArrayList testList = new BackwardArrayList();

      //Setting up initial list of 19 integers
      for (int i = 19; i >= 1; i--){
         System.out.printf("\tAdding integer %d to position %d\n", i, 1);
         addState = testList.addSomething(i);
         System.out.printf("\tInteger in position %d is %d\n", 1, testList.workingArray[testList.workingArray.length - 1]);
         if (addState == false){
            System.out.printf("\nInteger %d was not written correctly\n\n", i);
         }
      }

      //Testing that list increases size by the proper amount when it is full
      System.out.printf("\nList length is currently %d\n", testList.theSize());
      System.out.printf("Array length is currently %d\n", testList.workingArray.length);
      System.out.println("\tAdding integer 20 to position 20");
      addState = testList.addSomething(20, 20);
      if (addState == false){
         System.out.println("\nInteger was not written correctly\n\n");
      }
      System.out.printf("List length is now %d\n", testList.theSize());
      System.out.printf("Array length is currently %d\n", testList.workingArray.length);

      //Tests adding integers in different locations
      System.out.println("\nAdding integers 40, 41, 42, & 43 to positions 3, 6, 9, & 12 respectively");
      addState = testList.addSomething(3, 40);
      addState = testList.addSomething(6, 41);
      addState = testList.addSomething(9, 42);
      addState = testList.addSomething(12, 43);
      if (addState == false){
         System.out.println("\nAn integer was not written correctly\n\n");
      }
      System.out.println("Checking for location of integers listed above");
      for (int i = 1; i <= 4; i++){
         foundLocation = testList.findSomething(39 + i);
         if (foundLocation == -1){
            System.out.printf("Integer %d could not be found", 39 + i);
            continue;
         }
         System.out.printf("\tInteger %d is in location %d\n", 39 + i, foundLocation);
      }

      //Testing removing an integer
      System.out.printf("\nList length is currently %d\n", testList.theSize());
      System.out.println("\tRemoving integer 40 from list");
      foundLocation = testList.findSomething(40);
      System.out.printf("\tInteger 40 was in location %d\n", foundLocation);
      removeState = testList.removeSomething(foundLocation);
      if (removeState == false){
         System.out.println("\nInteger was not removed correctly\n\n");
      }
      System.out.printf("List length is currently %d\n", testList.theSize());
      System.out.println("\tSearching for integer 40");
      foundLocation = testList.findSomething(40);
      if (foundLocation == -1){
         System.out.println("\tInteger 40 could not be found");
      }
      else{
         System.out.printf("Integer 40 is in location %d\n", foundLocation);
      }
      System.out.printf("integer 3 is back in position %d\n", testList.findSomething(3));

      //Testing duplicated values and removing the first one
      System.out.println("\nRemoving integers 41, 42, & 43 from the list");
      for (int i = 1; i <= 3; i++){
         foundLocation = testList.findSomething(40 + i);
         removeState = testList.removeSomething(foundLocation);
         if (removeState == false){
            System.out.printf("Integer %d was not removed correctly", 40 + i);
            removeState = true;
         }
      }
      System.out.println("\tIntegers successfully removed");
      System.out.println("Adding integer 50 to position 10 and 15");
      addState = testList.addSomething(10, 50);
      addState = testList.addSomething(15, 50);
      foundLocation = testList.findSomething(50);
      System.out.printf("First instance of integer 50 is position %d\n", foundLocation);
      System.out.println("\tRemoving first instance");
      removeState = testList.removeSomething(foundLocation);
      if (removeState == false){
         System.out.println("Integer was not removed correctly");
         removeState = true;
      }
      foundLocation = testList.findSomething(50);
      System.out.printf("Second instance of integer 50 is position %d\n", foundLocation);
      System.out.println("\tRemoving second instance");
      removeState = testList.removeSomething(foundLocation);
      if (removeState == false){
         System.out.println("Integer was not removed correctly");
         removeState = true;
      }
      System.out.println("Testing if integer 50 is still in the list");
      foundLocation = testList.findSomething(50);
      if (foundLocation == -1){
         System.out.println("Integer 50 is no longer in the list");
      }
      else{
         System.out.println("Integer 50 was not removed correctly");
      }

      //Testing that list can increase more than one time
      System.out.printf("\nList length is currently %d\n", testList.theSize());
      System.out.printf("Array length is currently %d\n", testList.workingArray.length);
      for (int i = 21; i <= 29; i++){
         System.out.printf("\tAdding integer %d to position %d\n", i, i);
         addState = testList.addSomething(i, i);
         System.out.printf("\tInteger in position %d is %d\n", i, testList.workingArray[30 - i]);
         if (addState == false){
            System.out.printf("\nInteger %d was not written correctly\n\n", i);
         }
      }
      System.out.println("\tAdding integer 30 to position 30");
      addState = testList.addSomething(30, 30);
      System.out.printf("\tInteger in position 30 is %d\n", testList.workingArray[45 - 30]);
      if (addState == false){
         System.out.printf("\nInteger %d was not written correctly\n\n", 30);
      }
      System.out.printf("List length is now %d\n", testList.theSize());
      System.out.printf("Array length is currently %d\n", testList.workingArray.length);
      for (int i = 31; i <= 44; i++){
         System.out.printf("\tAdding integer %d to position %d\n", i, i);
         addState = testList.addSomething(i, i);
         System.out.printf("\tInteger in position %d is %d\n", i, testList.workingArray[45 - i]);
         if (addState == false){
            System.out.printf("\nInteger %d was not written correctly\n\n", i);
         }
      }
      System.out.println("\tAdding integer 45 to position 45");
      addState = testList.addSomething(45, 45);
      System.out.printf("\tInteger in position 45 is %d\n", testList.workingArray[67 - 45]);
      if (addState == false){
         System.out.printf("\nInteger %d was not written correctly\n\n", 45);
      }
      System.out.printf("List length is now %d\n", testList.theSize());
      System.out.printf("Array length is currently %d\n", testList.workingArray.length);

      //Testing removing a number from an empty spot
      System.out.println("\nRemoving integer from empty position 50");
      removeState = testList.removeSomething(50);
      if (removeState == false){
         System.out.println("An integer cannot be removed from a nonexistant location");
      }
      else{
         System.out.println("Integer was successfully removed");
      }

      //Testing adding a number to a spot past the list length
      System.out.println("\nAdding integer 50 to position 50");
      addState = testList.addSomething(50, 50);
      if (addState == false){
         System.out.println("An integer cannot be added to a position past the list length");
      }
      else{
         System.out.println("Integer was successfully added");
      }

      System.out.println("\nBackwardArrayList class successfully tested");
      System.out.println("Terminating driver\n");
   }
}

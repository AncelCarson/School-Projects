/**
*  @author Ancel Carson
*  Assignment 9
*  26/10/18
*  Total Time Worked: 2:15
*  Windows 10
*  Atom and Command Line
*  Circular array class that handles collisions and hashtables
*/

import java.util.LinkedList;
import java.util.List;
public class MyCircularArray{

   //Variable Declarations
   private int newArrayLength = 0,        //Array length used what increasing size
      arrayLength = 175,                  //Starting length of working array if no other is given
      percentFill = 0,                    //Defined percentage that working array can be filled
      maxFill = 0,                        //Number of names that can be added before the array increases in size
      numValues = 0,                      //Number of names added to the working array
      collisionsNum = 0,                  //Number of collisions when adding a name
      hashType = 0;                       //The hash table that creted the key
   private boolean makeBigOrder = true,   //Controls which array will be used when making array bigger
      makeBig = true,                     //Boolean if the array was successfully enlarged
      grow = false,                       //Says if the array will be enlarged or not
      chain = false;                      //Says if the array uses chaining
   private String[] workingArray = null,  //Array that names will be added to
      array2 = null,                      //Array used when increasing array size
      array1 = null;                      //Array used when increasing array size
   private List[] chainArray = null;      //Array of linked lists to be used as buckets

   /**
   * Default constructor
   */
   MyCircularArray(){
      hashType = 2;        //Selects polynomial hashtable
      workingArray = new String[arrayLength];
      grow = true;         //Will increase in size
      percentFill = 61;    //Increase when 61% full
      maxFill = 106;       //Number of values to reach before increasing
   }

   /**
   * Constructor for a given length
   * @param hashChoice     Hashtable chice by user
   * @param length         Length of array defined by user
   */
   MyCircularArray(int hashChoice, int length){
      hashType = hashChoice;
      arrayLength = length;
      workingArray = new String[arrayLength];
   }

   /**
   * Constructor for a given length and fill percent
   * @param hashChoice     Hashtable chice by user
   * @param length         Length of array defined by user
   * @param values         Array fill percent defined by user
   */
   MyCircularArray(int hashChoice, int length, int value){
      hashType = hashChoice;
      grow = true;
      arrayLength = length;
      workingArray = new String[arrayLength];
      percentFill = value;
      maxFill = (int)(((float)percentFill / 100.0) * (float)length);
   }

   /**
   * Constructor for a bucket array with given length
   * @param hashChoice     Hashtable chice by user
   * @param length         Length of array defined by user
   * @param choice         Denotes the array will use chaining
   */
   MyCircularArray(int hashChoice, int length, boolean choice){
      hashType = hashChoice;
      arrayLength = length;
      chainArray = new List[length];
      for(int i = 0; i < length; i++){
         chainArray[i] = new LinkedList();
      }
      chain = choice;
   }

   /**
   * Adds an integer to the top of the stack
   * @param indexValue     The position where the name should be added
   * @param name           The name that is to be added
   */
   void add(int indexValue, String name){
      int tempCollisions = 0;
      if(chain){           //If it is a bucket array
         numValues++;
         chainArray[indexValue].add(name);
      }
      else if(grow){       //If the array will grow
         numValues++;
         addToArray(indexValue, name, workingArray);
         if(numValues == maxFill){
            grow = makeBigger();
         }
      }
      else{                //default condition
         numValues++;
         addToArray(indexValue, name, workingArray);
      }
   }

   /**
   * Returns true or false if the stack is empty or not
   * @return               True is stackLength is 0 false if it is not
   */
   boolean isEmpty(){
      return numValues == 0;
   }

   /**
   * Returns the number of filled spaces in the array
   * @return               Number of values that have been added
   */
   int getLength(){
      return arrayLength;
   }

   /**
   * Returns teh number of collisiosn that have happened in workingArray
   * @return               Number of collisions
   */
   int getCollisions(){
      return collisionsNum;
   }

   /**
   * Returns true or false if the stack is empty or not
   * @return               True is stackLength is 0 false if it is not
   */
   void getBuckets(){
      if(chain){           //Makes sure the array uses chaining

         //Runs a number of times equal to array length and outputs length of each linkd list
         for(int i = 0; i < arrayLength; i++){
            System.out.printf("\tBucket %d - %d\n", i + 1, chainArray[i].size());
         }
      }
      else{                //Displays output if it is not a bucket array
         System.out.println("Array does not use chaining");
      }
   }

   private int addToArray(int indexValue, String name, String[] addArray){
      if(indexValue >= addArray.length){
         if(addArray[indexValue - addArray.length] != null){
            collisionsNum++;
            addToArray(indexValue + 1, name, addArray);
         }
         addArray[indexValue - addArray.length] = name;
      }
      else{
         if(addArray[indexValue] != null){
            collisionsNum++;
            addToArray(indexValue + 1, name, addArray);
         }
         addArray[indexValue] = name;
      }
      return indexValue;
   }

   /**
   * Makes the workingArraybigger so the list can continue uninterupted
   * @return      If the operation was a success or not
   */
   private boolean makeBigger(){
      int newIndex = 0;                   //Indeg after ecah name is rehashed
      grow = false;                       //Makes sure makeBigger is not accidentially called again
      newArrayLength = arrayLength * 2;   //Doubles length of the array

      //Says to use array1
      if (makeBigOrder == true){
         array1 = new String[newArrayLength];

         //Runs for the length of the working array
         for (int i = 0; i < arrayLength; i++){

            //Catches if there is no name at that index
            if(workingArray[i] == null){
               continue;
            }

            //Rehashes each value
            switch(hashType){
               case 1:
                  newIndex = HashCase.ASCIIHash(workingArray[i], newArrayLength);
                  break;
               case 2:
                  newIndex = HashCase.bookHash(workingArray[i], newArrayLength);
                  break;
               case 3:
                  newIndex = HashCase.myHash(workingArray[i], newArrayLength);
                  break;
            }

            //Adds name to the new array
            addToArray(newIndex, workingArray[i], array1);
         }

         //Sets workingArray to array1
         workingArray = array1;
      }

      //Says to use array2
      if (makeBigOrder == false){
         array2 = new String[newArrayLength];

         //Runs for the length of the working array
         for (int i = 0; i < arrayLength; i++){

            //Catches if there is no name at that index
            if(workingArray[i] == null){
               continue;
            }

            //Rehashes each value
            switch(hashType){
               case 1:
                  newIndex = HashCase.ASCIIHash(workingArray[i], newArrayLength);
                  break;
               case 2:
                  newIndex = HashCase.bookHash(workingArray[i], newArrayLength);
                  break;
               case 3:
                  newIndex = HashCase.myHash(workingArray[i], newArrayLength);
                  break;
            }

            //Adds name to the new array
            addToArray(newIndex, workingArray[i], array2);
         }

         //Sets workingArray to array2
         workingArray = array2;
      }
      arrayLength = newArrayLength;
      makeBigOrder = !makeBigOrder;
      maxFill = (int)(((float)percentFill / 100.0) * (float)arrayLength);
      return true;         //Resets grow to true
   }
}
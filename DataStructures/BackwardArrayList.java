/**
*  @author Ancel Carson
*  Assignment 2
*  17/9/18
*  Total Time Worked: 2:15
*  Windows 10
*  Atom and Command Line
*  Personal made arrayList class to function in place of jave defined class
*/

public class BackwardArrayList{

   /**
   * Variables used by BackwardArrayList class
   * @param foundLocation     Location of integer found in findSomething
   * @param listLength        Current number of relevant integers in the workingArray
   * @param newArrayLength    Temporary holding place for array length while increasing size
   * @param arrayLength       Length of the workingArray
   * @param array1            First temporary holding array while workingArray is enlarged
   * @param array2            Second temporary holding array while workingArray is enlarged
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param operationSuccess  General boolean to return if methods were successful
   * @param makeBigOrder      Boolean that controls which of the holding arrays are used
   * @param makeBig           Boolean to return if makeBigger was successful
   */
   private int foundLocation = 0, listLength = 0, newArrayLength = 0, arrayLength = 20;
   private int[] array2 = null, array1 = null;
   int[] workingArray = new int[arrayLength];
   private boolean operationSuccess = true, makeBigOrder = true, makeBig = false;

   /**
   * Constructor that creates object in driving program
   */
   BackwardArrayList(){

   }

   /**
   * Returns the current length of the list when asked br driver
   * @param listLength        Current number of relevant integers in the workingArray
   */
   int theSize(){
      return listLength;
   }

   /**
   * Adds a given integer to the end of the list
   * @param listLength        Current number of relevant integers in the workingArray
   * @param arrayLength       Length of the workingArray
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param operationSuccess  General boolean to return if methods were successful
   * @param makeBig           Boolean to return if makeBigger was successful
   * @param addValue          Value given by driver to add to the end of the list
   * @return                  Returns if the operation was successful or not
   */
   boolean addSomething(int addValue){
      operationSuccess = true;
      if (listLength != 0){
         for (int i = listLength; i >= 1; i--){
            workingArray[arrayLength - (i + 1)] = workingArray[arrayLength - i];
         }
      }
      workingArray[arrayLength - 1] = addValue;
      listLength++;
      if (listLength == arrayLength){
         makeBig = makeBigger();
         if (makeBig == false){
            operationSuccess = false;
         }
      }
      return operationSuccess;
   }

   /**
   * Adds a given integer to a given position
   * @param listLength        Current number of relevant integers in the workingArray
   * @param arrayLength       Length of the workingArray
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param operationSuccess  General boolean to return if methods were successful
   * @param makeBig           Boolean to return if makeBigger was successful
   * @param addPosition       Position given by driver to add given integer to
   * @param addValue          Value given by driver to add to the end of the list
   * @return                  Returns if the operation was successful or not
   */
   boolean addSomething(int addPosition, int addValue){
      operationSuccess = true;
      if (addPosition > listLength + 1 || addPosition < 1){
         operationSuccess = false;
         return operationSuccess;
      }
      else if (addPosition <= listLength + 1){
         for (int i = 0; i < (arrayLength - addPosition); i++){
            workingArray[i] = workingArray[i + 1];
         }
         workingArray[arrayLength - addPosition] = addValue;
      }
      listLength++;
      if (listLength == arrayLength){
         makeBig = makeBigger();
         if (makeBig == false){
            operationSuccess = false;
         }
      }
      return operationSuccess;
   }

   /**
   * Removes a given integer at a given position
   * @param listLength        Current number of relevant integers in the workingArray
   * @param arrayLength       Length of the workingArray
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param operationSuccess  General boolean to return if methods were successful
   * @param removePosition    Value given by driver for location to remove
   * @return                  Returns if the opperation was successful or not
   */
   boolean removeSomething(int removePosition){
      operationSuccess = true;
      if (removePosition > listLength || removePosition < 1){
         operationSuccess = false;
         return operationSuccess;
      }
      else if (removePosition == listLength){
         workingArray[arrayLength - listLength] = 0;
      }
      else if (removePosition < listLength){
         for (int i = removePosition; i < listLength; i++){
            workingArray[arrayLength - i] = workingArray[arrayLength - (i + 1)];
         }
         workingArray[arrayLength - listLength] = 0;
      }
      listLength--;
      return operationSuccess;
   }

   /**
   * Returns the first instance of a requested integer
   * @param foundLocation     Location of integer found in findSomething
   * @param listLength        Current number of relevant integers in the workingArray
   * @param arrayLength       Length of the workingArray
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param searchFor         Given integer to search workingArray for
   * @return                  Integer position of the desired integer
   */
   int findSomething(int searchFor){
      foundLocation = -1;
      for (int i = 1; i <= listLength; i++){
         if (workingArray[arrayLength - i] == searchFor){
            foundLocation = i;
            break;
         }
      }
      return foundLocation;
   }

   /**
   * Makes the workingArraybigger so the list can continue uninterupted
   * @param newArrayLength    Temporary holding place for array length while increasing size
   * @param arrayLength       Length of the workingArray
   * @param array1            First temporary holding array while workingArray is enlarged
   * @param array2            Second temporary holding array while workingArray is enlarged
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param makeBigOrder      Boolean that controls which of the holding arrays are used
   * @return                  Boolean saying the operation was successful
   */
   private boolean makeBigger(){
      newArrayLength = (arrayLength / 2) + arrayLength;
      if (makeBigOrder == true){
         array1 = new int[newArrayLength];
         for (int i = 1; i <= listLength; i++){
            array1[newArrayLength - i] = workingArray[arrayLength - i];
         }
         workingArray = array1;
      }
      if (makeBigOrder == false){
         array2 = new int[newArrayLength];
         for (int i = 1; i <= listLength; i++){
            array2[newArrayLength - i] = workingArray[arrayLength - i];
         }
         workingArray = array2;
      }
      arrayLength = newArrayLength;
      makeBigOrder = !makeBigOrder;
      return true;
   }
}
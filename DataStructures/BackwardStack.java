/**
*  @author Ancel Carson
*  Assignment 5
*  Code and comments used from BackwardsArrayList class
*  2/10/18
*  Total Time Worked: 45
*  Windows 10
*  Atom and Command Line
*  Brief Program Description expected input, output, and process
*/

public class BackwardStack{

   /**
   * Variables used by BackwardStack class
   * @param popInt            Integer to be sent to another program
   * @param stackLength       Current number of relevant integers in the workingArray
   * @param newArrayLength    Temporary holding place for array length while increasing size
   * @param arrayLength       Length of the workingArray
   * @param array1            First temporary holding array while workingArray is enlarged
   * @param array2            Second temporary holding array while workingArray is enlarged
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param operationSuccess  General boolean to return if methods were successful
   * @param makeBigOrder      Boolean that controls which of the holding arrays are used
   * @param makeBig           Boolean to return if makeBigger was successful
   */
   private int popInt, stackLength = 0, newArrayLength = 0, arrayLength = 20;
   private int[] array2 = null, array1 = null;
   private int[] workingArray = new int[arrayLength];
   private boolean operationSuccess = true, makeBigOrder = true, makeBig = false;

   /**
   * Constructor that creates object in driving program
   */
   BackwardStack(){

   }

   /**
   * Adds an integer to the top of the stack
   * @param addValue          Value given by driver to add to the end of the list
   * @param operationSuccess  General boolean to return if methods were successful
   * @param stackLength       Current number of relevant integers in the workingArray
   * @param workingArray      Array that is sent to the driving program and all operations are done to
   * @param arrayLength       Length of the workingArray
   * @param makeBig           Boolean to return if makeBigger was successful
   * @return                  Returns if the operation was successful or not
   */
   boolean thePush(int addValue){
      operationSuccess = true;
      stackLength++;
      workingArray[arrayLength - stackLength] = addValue;
      if (stackLength == arrayLength){
         makeBig = makeBigger();
         if (makeBig == false){
            operationSuccess = false;
         }
      }
      return operationSuccess;
   }

   /**
   * Returns the top integer from the stack to another program
   * @param popInt         Integer to be returned to driver
   * @param workingArray   Array that is sent to the driving program and all operations are done to
   * @param arrayLength    Length of the workingArray
   * @param stackLength    Current number of relevant integers in the workingArray
   * @return               Integer that was at the top of the stack
   */
   int thePop(){
      popInt = workingArray[arrayLength - stackLength];
      workingArray[arrayLength - stackLength] = 0;
      stackLength--;
      return popInt;
   }

   /**
   * Returns true or false if the stack is empty or not
   * @param stacklength    Current number of relevant integers in the workingArray
   * @return               True is stackLength is 0 false if it is not
   */
   boolean isEmpty(){
      return stackLength == 0;
   }

   /**
   * Prints the contents of the stack to another program
   * @param stackLength    Current number of relevant integers in the workingArray
   * @param workingArray   Array that is sent to the driving program and all operations are done to
   * @param arrayLength    Length of the workingArray
   */
   void printStack(){
      System.out.println("Contents of stack:");
      System.out.print("\t[");
      for (int i = stackLength; i >= 1; i--){
         System.out.print(workingArray[arrayLength - i]);
         if (i != 1){
            System.out.print(",");
         }
      }
      System.out.println("]");
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
         for (int i = 1; i <= stackLength; i++){
            array1[newArrayLength - i] = workingArray[arrayLength - i];
         }
         workingArray = array1;
      }
      if (makeBigOrder == false){
         array2 = new int[newArrayLength];
         for (int i = 1; i <= stackLength; i++){
            array2[newArrayLength - i] = workingArray[arrayLength - i];
         }
         workingArray = array2;
      }
      arrayLength = newArrayLength;
      makeBigOrder = !makeBigOrder;
      return true;
   }
}
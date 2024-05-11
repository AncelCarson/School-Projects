/**
*  @author Ancel Carson
*  Assignment 5
*  2/10/18
*  Total Time Worked: 1:10
*  Windows 10
*  Atom and Command Line
*  Brief Program Description expected input, output, and process
*/

import java.util.*;
public class CrazyCalc{

   /**
   * Main driving class of the CrazyCalc class
   * @param check                      Boolean value that is true as long as program is runnng
   * @param theInput                   Scanner that is primary input for program
   * @param myStack                    BackwardStack object to hold values
   * @throws InputMismatchException    Makes sure number given is an integer
   */
   public static void main(String[] args){

      //Declare Variables
      boolean check = true;
      Scanner theInput = new Scanner(System.in);
      BackwardStack myStack = new BackwardStack();

      //While loop that runs the menu and handles different selections
      while(check){
         menu();
         switch(theInput.next().charAt(0)){
            case '+': doSomething(myStack, 1); break;
            case '-': doSomething(myStack, 2); break;
            case '*': doSomething(myStack, 3); break;
            case '/': doSomething(myStack, 4); break;
            case '#':
               System.out.println("Please enter a number.");

               //Makes sure given input is an integer
               try{
                  myStack.thePush(theInput.nextInt());
               }
               catch(InputMismatchException e1){
                  System.out.println("Input must be an integer value.");
                  theInput.nextLine();
               }
               break;
            case '?': myStack.printStack(); break;
            case 'x': check = false; break;
            case 'X': check = false; break;
            default:
               System.out.println("Unknown input was given.\nPlease try again.");
               break;
         }
      }

      //Output Statements
      System.out.println("Program has been completed.\n");
      System.out.println("Thank you for using CrazyCalc.");
      theInput.close();
   }

   /**
   * Method that handles mathmatical operations
   * @param myStack     Stack passed from main method
   * @param choice      What operation the user wants
   * @param num1        First number in mathmatical operation
   * @param num2        Second number in mathmatical operation
   * @param finalNum    Result of mathmatical operation
   */
   static void doSomething(BackwardStack myStack, int choice){
      int num1, num2, finalNum = 0;

      //Attempting to retrieve integer at the top of the stack
      if(myStack.isEmpty()){
         num1 = getNumber();
      }
      else{
         num1 = myStack.thePop();
      }
      //Attempting to retrieve integer at the top of the stack
      if(myStack.isEmpty()){
         num2 = getNumber();

         //Handles if the user is trying to divide by 0
         if(num2 == 0 && choice == 4){
            System.out.println("Program cannot divide by 0.");
            System.out.println("Please choose a diffrent operation.");
            choice = redoMenu();
         }
      }
      else{
         num2 = myStack.thePop();
         //Handles if the user is trying to divide by 0
         if(num2 == 0 && choice == 4){
            System.out.println("Program cannot divide by 0.");
            System.out.println("Please choose a diffrent operation.");
            choice = redoMenu();
         }
      }

      //Switch statements that controls correct mathmatical operation
      switch(choice){
         case 1:
            finalNum = num1 + num2;
            System.out.printf("%d + %d = %d\n", num1, num2, finalNum);
            break;
         case 2:
            finalNum = num1 - num2;
            System.out.printf("%d - %d = %d\n", num1, num2, finalNum);
            break;
         case 3:
            finalNum = num1 * num2;
            System.out.printf("%d * %d = %d\n", num1, num2, finalNum);
            break;
         case 4:
            finalNum = num1 / num2;
            System.out.printf("%d / %d = %d\n", num1, num2, finalNum);
            break;
         default:
            myStack.thePush(num2);
            finalNum = num1;
            System.out.println("Unknown input was given.\nPlease start again.");
            break;
      }
      myStack.thePush(finalNum);
   }

   /**
   * Askes the user for a number if there are not enough in the stack
   * @param methodInput                Scanner the runs inside of this method
   * @throws InputMismatchException    Makes sure number given is an integer
   * @return                           New integer given by user
   */
   private static int getNumber(){
      int newInt = 0;
      Scanner methodInput = new Scanner(System.in);
      System.out.println("\nThere were not enough numbers in the stack.");
      System.out.println("Please enter an aditional number.");

      //Makes sure given input is an integer
      try{
         newInt = methodInput.nextInt();
      }
      catch(InputMismatchException e1){
         System.out.println("Input must be an integer value.");
         methodInput.nextLine();

         //Runs method again if input is still not an integer
         newInt = getNumber();
      }
      methodInput.close();
      return newInt;
   }

   /**
   * Menu that is called to show all operations of the program
   */
   static void menu(){
      System.out.println("\n    Choose an operation     ");
      System.out.println("|--------------------------|");
      System.out.println("|  Mathmatical operations  |");
      System.out.println("|--------------------------|");
      System.out.println("| + : Add two numbers      |");
      System.out.println("| - : Subtract two numbers |");
      System.out.println("| * : Multiply two numbers |");
      System.out.println("| / : Divide two numbers   |");
      System.out.println("|--------------------------|");
      System.out.println("|    Program operations    |");
      System.out.println("|--------------------------|");
      System.out.println("| # : Enter a number       |");
      System.out.println("| ? : Check stack contents |");
      System.out.println("| x : End program          |");
      System.out.println("|--------------------------|");
   }

   /**
   * Menu that is called when the user tries to divide by 0
   * @param newChoice      New operation selection
   * @param methodInput    Scanner the runs inside of this method
   * @return               New choice value to doSomething method
   */
   private static int redoMenu(){
      int newChoice = 0;
      Scanner methodInput = new Scanner(System.in);
      System.out.println("\n|--------------------------|");
      System.out.println("|  Mathmatical operations  |");
      System.out.println("|--------------------------|");
      System.out.println("| + : Add two numbers      |");
      System.out.println("| - : Subtract two numbers |");
      System.out.println("| * : Multiply two numbers |");
      System.out.println("|--------------------------|");
      switch(methodInput.next().charAt(0)){
         case '+': newChoice = 1; break;
         case '-': newChoice = 2; break;
         case '*': newChoice = 3; break;
      }
      methodInput.close();
      return newChoice;
   }
}
/*
* @author: Harrison Berryhill
* Teacher: Dr. Rouse
* Class: Computer Science 2 Section 1
* Assignment 6
* Date completed: Apr. 15, 2019
* Total Time Coding:
* Operating System used: Windows 10
* IDE: JGrasp
* Program Description:
*/
import java.Scanner;

public class Assign6{
   public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         PrintWriter outputData = new PrintWriter(ouputFile);

         int accInput;
         String firstName;
         String lastName;
         String accNum;
         double balance;

         System.out.println("Would you like to setup a checking or savings account today?");
         System.out.println("1 - Checking");
         System.out.println("2 - Savings");
         accInput = input.nextInt();

         if(accInput == 1){
            Checking acc = new Checking();
         }
         else if(accInput == 2){
            Savings acc = new Savings();
         }

         System.out.print("What is the first and last name of the account?: ");
         firstName = input.next();
         lastName = input.next();

         System.out.print("What is your account number?: ");
         accNum = input.next();

         System.out.print("What is your balance in the account?: ");
         balance = input.nextDouble();
   //ask user which account to set up
   //ask user name, account number, and balance
   //use case statements to make menu selection
   }
}
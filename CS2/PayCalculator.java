/* Program Written for CSII
   Assignment 4
   Program written by Ancel Carson
   23/2/18
   Windows 10
   Atom and Command Line
   This code takes a series of employees, hours worked, and their pay rate to output a
   single unified chart.
*/

import java.util.Scanner;
public class PayCalculator{
   public static void main(String[] args){

      //Declare Variables
      String[][] names = new String[35][2];
      float[][] nums = new float[35][3];
      int numEmploy = 0, payLength;
      Scanner theInput = new Scanner(System.in);

      //Input Statements
      System.out.printf("Please enter the first name of employee %d.\n", numEmploy + 1);
      names[numEmploy][0] = theInput.next();
      while(!names[numEmploy][0].equals("end")){
         System.out.printf("Please enter the last name of employee %d.\n", numEmploy + 1);
         names[numEmploy][1] = theInput.next();
         System.out.printf("Please enter the number of hours worked for ");
         System.out.printf("employee %d.\n", numEmploy + 1);
         nums[numEmploy][0] = theInput.nextFloat();
         System.out.printf("Please enter the pay rate for employee %d ", numEmploy + 1);
         System.out.printf("in $ per hour.\n");
         nums[numEmploy][1] = theInput.nextFloat();
         numEmploy++;
         System.out.printf("Please enter the first name of employee %d. ", numEmploy + 1);
         System.out.println("If there are no more employees enter \"end\".");
         names[numEmploy][0] = theInput.next();
      }

      //Calculations
      netPay(nums, numEmploy);

      //Output Statements
      System.out.println("|-----------|------------|-----------|");
      System.out.println("| Last Name | First Name |  Net Pay  |");
      System.out.println("|-----------|------------|-----------|");
      for(int i=0; i < numEmploy; i++){
         switch(names[i][1].length()){
            case 1:
               System.out.printf("|  %s        ",names[i][1]);
               break;
            case 2:
               System.out.printf("|  %s       ",names[i][1]);
               break;
            case 3:
               System.out.printf("|  %s      ",names[i][1]);
               break;
            case 4:
               System.out.printf("|  %s     ",names[i][1]);
               break;
            case 5:
               System.out.printf("|  %s    ",names[i][1]);
               break;
            case 6:
               System.out.printf("|  %s   ",names[i][1]);
               break;
            case 7:
               System.out.printf("|  %s  ",names[i][1]);
               break;
            case 8:
               System.out.printf("|  %s ",names[i][1]);
               break;
         }
         switch(names[i][0].length()){
            case 1:
               System.out.printf("|  %s         ",names[i][0]);
               break;
            case 2:
               System.out.printf("|  %s        ",names[i][0]);
               break;
            case 3:
               System.out.printf("|  %s       ",names[i][0]);
               break;
            case 4:
               System.out.printf("|  %s      ",names[i][0]);
               break;
            case 5:
               System.out.printf("|  %s     ",names[i][0]);
               break;
            case 6:
               System.out.printf("|  %s    ",names[i][0]);
               break;
         }
         if (nums[i][2] < 10){
            System.out.printf("|  $%.2f    |\n",nums[i][2]);
         }
         else if (nums[i][2] < 100){
            System.out.printf("|  $%.2f   |\n",nums[i][2]);
         }
         else if (nums[i][2] < 1000){
            System.out.printf("|  $%.2f  |\n",nums[i][2]);
         }
         else if (nums[i][2] < 10000){
            System.out.printf("|  $%.2f |\n",nums[i][2]);
         }
         else{
            System.out.printf("|  $%.2f|\n",nums[i][2]);
         }
         System.out.println("|-----------|------------|-----------|");
      }
   }

   public static void netPay(float [][] array, int num){
      for(int i = 0; i < num; i++){
         array[i][2] = array[i][0] * array[i][1];
      }
   }
}

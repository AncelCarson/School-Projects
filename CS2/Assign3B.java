/* Program written by Ancel Carson
   9/4/18
   Windows 10
   Atom and Command Line
   Brief Program Description expected input, output, and process
*/

import java.util.Scanner;
import java.io.*;
public class Assign3B
{
   public static void main(String[] args)throws FileNotFoundException
   {

      //Declare Variables
      int competitor;
      int[] firstRound = new int[5];
      int[] secondRound = new int[5];
      int[] topScores = {0, 0, 0};
      double firstRoundAverage, secondRoundAverage;
      double[] scores;
      String[][] info;
      File inputFile = new File(args[0]);
      Scanner theInput = new Scanner(inputFile);

      System.out.println("Please enter the number of competitors you want with the number being less than or equal to 25 and more than or equal to 3");
      competitor = theInput.nextInt();
      info = new String[competitor][3];
      scores = new double[competitor];

      for(int i = 0; i < competitor; i++){
         System.out.println("Please enter the competitors first name, last name, and state each separated by a space and the state abbreviated: ");
         info[i][0] = theInput.next();
         info[i][1] = theInput.next();
         info[i][2] = theInput.next();

         System.out.println("Enter the scores for round 1:");
         for(int j = 0; j < 5; j++){
            System.out.println("Enter score for judge " + (j + 1));
            firstRound[j] = theInput.nextInt();
         }

         System.out.println("Enter the scores for round 2:");
         for(int j = 0; j < 5; j++){
            System.out.println("Enter score for judge " + (j + 1));
            secondRound[j] = theInput.nextInt();
         }

         min(firstRound);
         max(firstRound);
         firstRoundAverage = avg(firstRound);
         min(secondRound);
         max(secondRound);
         secondRoundAverage = avg(secondRound);

         if (secondRoundAverage > firstRoundAverage){
            scores[i] = secondRoundAverage;
         }
         else{
            scores[i] = firstRoundAverage;
         }
      }

      System.out.println("");

      for(int i = 0; i < competitor; i++){
         System.out.printf("From %s, %s %s\'s score is: %.2f\n", info[i][2], info[i][0], info[i][1], scores[i]);

         if(scores[i] > scores[topScores[0]]){
            topScores[2] = topScores[1];
            topScores[1] = topScores[0];
            topScores[0] = i;
         }
         else if(scores[i] > scores[topScores[1]]){
            topScores[2] = topScores[1];
            topScores[1] = i;
         }
         else if(scores[i] > scores[topScores[2]]){
            topScores[2] = i;
         }
      }

      System.out.println("Final Results Are:");
      System.out.printf("Gold - %s %s\n", info[topScores[0]][0], info[topScores[0]][1]);
      System.out.printf("Silver - %s %s\n", info[topScores[1]][0], info[topScores[1]][1]);
      System.out.printf("Bronze - %s %s\n", info[topScores[2]][0], info[topScores[2]][1]);
   }

   public static double avg(int[] theScores){
      double total = 0;
      double ave = 0;
      for (int i = 0; i < 5; i++){
         total = (double)theScores[i] + total;
      }
      ave = total/3.0;
      return ave;
   }

   public static void min(int[] theScores){
      int absMin = 100;
      int remove = 5;
      for(int i = 0; i < 5; i++){
         if(theScores[i] <= absMin){
            absMin = theScores[i];
            remove = i;
         }
      }
      theScores[remove] = 0;
   }

   public static void max(int[] theScores){
      int absMax = 0;
      int remove = 5;
      for(int i = 0; i < 5; i++){
         if(theScores[i] >= absMax){
            absMax = theScores[i];
            remove = i;
         }
      }
      theScores[remove] = 0;
   }
}

import java.io.*;
import java.util.*;

public class Assign4{
   public static void main(String[] args)throws IOException{
      File inputFile = new File("TrucksExample.txt");
      File outputFile = new File("TruckFines.txt");

      Scanner inputData = new Scanner(inputFile);
      PrintWriter outputData = new PrintWriter(outputFile);

      int numTrucks = inputData.nextInt();
      int numDays = inputData.nextInt();

      System.out.println(numTrucks + " " + numDays);

      String[] weekdays = new String[numDays];
      int[][] truckWeight = new int[numTrucks][numDays];
      int[][] truckFines = new int[numTrucks][numDays];

      inputTrucks(inputData, weekdays, truckWeight);
      calculatefines(truckWeight, truckFines);
      outputTrucks(outputData, weekdays, truckWeight, truckFines);

      System.out.println("Program is complete");

      inputData.close();
      outputData.close();

   }

   static void inputTrucks(Scanner inputData, String[] weekdays, int[][] theTruckWeight) throws IOException{ //calculates the trucks
      for(int i = 0; i < weekdays.length; i++){
         weekdays[i] = inputData.next();
      }
      for(int j = 0; j < theTruckWeight.length; j++){
         for(int k = 0; k < weekdays.length; k++){
            theTruckWeight[j][k] = inputData.nextInt();
            }
         }
         inputData.close();
   }

   static void calculatefines(int[][] theTruckWeight, int[][] theTruckFines){ //calculates the fines
      int temp = 0;
      for(int j = 0; j < theTruckWeight.length; j++){
         for(int c = 0; c < theTruckWeight[j].length; c++){
            if(theTruckWeight[j][c] <= 80000){
               theTruckFines[j][c] = 0;
            }
            else if(theTruckWeight[j][c] > 80000){
               temp = theTruckWeight[j][c];
               temp -= 80000;
               temp /= 100;
               temp++;
               theTruckFines[j][c] = (50 * temp);
            }
         }
      }
   }


   static void outputTrucks(PrintWriter outputData, String[] weekdays, int[][] theTruckWeight, int[][] theTruckFines){ //outputes results

      String weekday = "";
      String truck = "";

      for(int c = 0; c < weekdays.length; c++){
         weekday = weekdays[c] + (((c+1)/7)+1);
         outputData.print("For " + weekday + "\r\n\r\nTrucks without fines are:\r\n");

         for(int j = 0; j < theTruckWeight.length; j++){
            if(theTruckFines[j][c] == 0){
               truck = "Truck" + (j+1);
               outputData.println(truck);
            }
         }
         outputData.print("\r\nTrucks with fines are:\r\n");
         for(int j = 0; j < theTruckWeight.length; j++){
            if(theTruckFines[j][c] > 0){
               truck = "Truck" + (j+1);
               outputData.printf(truck + " $" + theTruckFines[j][c] + "\r\n");
            }
         }
         outputData.print("\r\n");
      }
      outputData.close();
   }
}

/**
*  @author Ancel Carson
*  Assignment ##
*  25/9/18
*  Total Time Worked:
*  Windows 10
*  Atom and Command Line
*  Brief Program Description expected input, output, and process
*/

import java.util.Scanner;
import java.util.Arrays;
public class RandomNumber{
   public static void main(String[] args){
      Double[] myArray = new Double[100000000];
      StopWatch myClock = new StopWatch();

      myClock.start();
      for(int i = 0; i < myArray.length; i++){
         myArray[i] = Math.random();
      }
      myClock.stop();
      System.out.println(myClock.getElapsedTime());

      myClock.start();
      Arrays.sort(myArray);
      myClock.stop();
      System.out.println(myClock.getElapsedTime());
   }
}
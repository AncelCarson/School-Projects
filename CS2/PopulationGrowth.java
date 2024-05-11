/* Program Written for CSII
   Assignment 1
   Program written by Ancel Carson
   9/3/18
   Windows 10
   Atom and Command Line
   This program takes the estimated rate of birth, death, and immigration in seconds and
   projects the estimated population given an initial value.
*/

public class PopulationGrowth{
   public static void main(String[] args){

      //Variables declarations
      int birthRate = 7, deathRate = 13, immigrantRate = 45, initialPop = 325637380;
      int yearsGrowth = 5, daysYear = 365;
      int secondsYear, birthTotal, deathTotal, immigrantTotal;
      int finalPop, firstPop, secondPop, thirdPop;

      //Calculations
      secondsYear = 365 * 24 * 60 * 60;
      birthTotal = ((secondsYear / birthRate) * yearsGrowth);
      deathTotal = ((secondsYear / deathRate) * yearsGrowth);
      immigrantTotal = ((secondsYear / immigrantRate) * yearsGrowth);
      finalPop = initialPop + birthTotal - deathTotal + immigrantTotal;
      firstPop = finalPop / 1000000;
      secondPop = (finalPop - (firstPop * 1000000)) / 1000;
      thirdPop = (finalPop - ((firstPop * 1000000) + (secondPop * 1000)));

      //Output Statements
      System.out.print("Projected population is ");
      System.out.println(firstPop + "," + secondPop + "," + thirdPop);
   }
}

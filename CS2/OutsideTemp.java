/* Program Written for CSII
   In Class Assignment 2
   Program Written by Ancel Carson
   7/2/18
   Wondows 10
   Atom and Command Line
   This program calculates the wind-chill at a certain location given outside temperature
   and wind speed.
*/

import java.util.Scanner;
public class OutsideTemp{
   public static void main(String[] args){

      //Variables Declared
      double windChill, windChillF, outTemp, windSpeed;
      String location;
      Scanner theInput = new Scanner(System.in);

      //Input Statements
      System.out.println("Please enter the location.");
      location = theInput.next();
      System.out.println("Please enter the current outside temperature in Fahrenheit.");
      System.out.print("Note that the temperature must be above -58*F");
      System.out.println(" and below 41*F.");
      outTemp = theInput.nextDouble();
      System.out.println("Please enter the current wind speed in mph.");
      System.out.println("Note that the wind speed must be above or equal to 2mph.");
      windSpeed = theInput.nextDouble();

      //Calculations
      windChillF = 35.74 + 0.6215 * outTemp - 35.75 * Math.pow(windSpeed,.16);
      windChill = windChillF + (0.4275 * outTemp * Math.pow(windSpeed,.16));

      //Output Statements
      System.out.printf("The wind-chill in %s with a temperature of ", location);
      System.out.printf("%.1f degrees with a windspeed of %.0f is ", outTemp, windSpeed);
      System.out.printf("%.3f degrees Farenheit", windChill);
   }
}

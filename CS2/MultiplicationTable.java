/* Program Written for CSII
   Slide Program 1
   Program written by Ancel Carson
   29/1/18
   Windows 10
   Atom and Command Line
   Creates a multiplicaton table.
*/

import java.util.Scanner;
public class MultiplicationTable {
   public static void main(String[] args) {

   // Display the table heading
   System.out.println("Multiplication Table");
   System.out.print("   ");

   // Display the number title
   for (int j = 1; j <= 9; j++)
     System.out.print("   " + j);

   System.out.println("\n *************************************** ");

   // Print table body
   for (int i = 1; i <= 9; i++) {
      System.out.print(i + " |");
      for (int j = 1; j <= 9; j++) {
        // Display the product and align properly
        System.out.printf("%4d", i * j);
      }
      System.out.println();
    }
  }
}

/* Program Written for CSII
   Assignment 6
   Program written by Ancel Carson
   5/3/18
   Windows 10
   Atom and Command Line
   This program takes in a users choice of shape and shape values then displays the volume
*/

import java.util.Scanner;
public class ShapeCalculator{
   public static void main(String[] args){

      //Declare Variables
      int counter = 0;
      int[] choice = new int[15];
      double tempRad, tempHi, tempLen, tempWid;
      Shapes[] myShape = new Shapes[15];
      Scanner theInput = new Scanner(System.in);

      //Input Statements
      while(true){
         menu();
         System.out.println("Please enter the number corresponding to your choice");
         choice[counter] = theInput.nextInt();
         if (choice[counter] == 5){
            break;
         }
         switch(choice[counter]){
            case 1:
               System.out.println("Please enter the radius of the sphere");
               tempRad = theInput.nextDouble();
               myShape[counter] = new Shapes(tempRad);
               break;
            case 2:
               System.out.println("Please enter the radius of the cylinder");
               tempRad = theInput.nextDouble();
               System.out.println("Please enter the height of the cylinder");
               tempHi = theInput.nextDouble();
               myShape[counter] = new Shapes(tempRad, tempHi);
               break;
            case 3:
               System.out.println("Please enter the radius of the cone");
               tempRad = theInput.nextDouble();
               System.out.println("Please enter the height of the cone");
               tempHi = theInput.nextDouble();
               myShape[counter] = new Shapes(tempRad, tempHi);
               break;
            case 4:
               System.out.println("Please enter the length of the pyramid");
               tempLen = theInput.nextDouble();
               System.out.println("Please enter the width of the pyramid");
               tempWid = theInput.nextDouble();
               System.out.println("Please enter the height of the pyramid");
               tempHi = theInput.nextDouble();
               myShape[counter] = new Shapes(tempLen, tempWid, tempHi);
               break;
         }
         counter++;
         System.out.println();
      }
      System.out.println();

      //Output Statements
      for(int i = 0; i < counter; i++){
         switch(choice[i]){
            case 1:
               System.out.printf("The volume of a sphere with radius");
               System.out.printf(" %.4f", myShape[i].radius);
               System.out.printf(" is %.4f cubic feet.\n\n", myShape[i].sphereVolume());
               break;
            case 2:
               System.out.printf("The volume of a cylinder with radius");
               System.out.printf(" %.4f and height", myShape[i].radius);
               System.out.printf(" %.4f", myShape[i].height);
               System.out.printf(" is %.4f cubic feet.\n\n", myShape[i].cylinderVolume());
               break;
            case 3:
               System.out.printf("The volume of a cone with radius");
               System.out.printf(" %.4f and height", myShape[i].radius);
               System.out.printf(" %.4f", myShape[i].height);
               System.out.printf(" is %.4f cubic feet.\n\n", myShape[i].coneVolume());
               break;
            case 4:
               System.out.printf("The volume of a pyramid with length");
               System.out.printf(" %.4f, width", myShape[i].length);
               System.out.printf(" %.4f, and height", myShape[i].width);
               System.out.printf(" %.4f", myShape[i].height);
               System.out.printf(" is %.4f cubic feet.\n\n", myShape[i].pyramidVolume());
               break;
         }
      }
   }

   //Menu Method
   public static void menu(){
      System.out.println("|--------------------|");
      System.out.println("| 1: Sphere          |");
      System.out.println("| 2: Cylinder        |");
      System.out.println("| 3: Cone            |");
      System.out.println("| 4: Pyramid         |");
      System.out.println("| 5: No more Shapes  |");
      System.out.println("|--------------------|");

   }
}

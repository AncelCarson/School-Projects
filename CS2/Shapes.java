/* Program Written for CSII
   In Class 2
   Program written by Ancel Carson
   5/3/18
   Windows 10
   Atom and Command Line
   Hands on example of object creation
*/

public class Shapes{

   //Global variables
   static final double thePi = Math.PI;
   double radius, height, length, width;

   //Constructor
   //Left for personal use later as well as an exampl of a default Constructor
   Shapes(){
      radius = 1;
      height = 1;
   }

   Shapes(double inRadius){
      radius = inRadius;
   }

   Shapes(double inRadius, double inHeight){
      radius = inRadius;
      height = inHeight;
   }

   Shapes(double inLength, double inWidth, double inHeight){
      length = inLength;
      width = inWidth;
      height = inHeight;
   }

   //Finds volume of a sphere
   double sphereVolume(){
      return thePi * radius * radius * radius * 4 / 3;
   }

   //Finds volume of a cone
   double coneVolume(){
      return thePi * radius * radius * height / 3.0;
   }

   //Finds volume of a cylinder
   double cylinderVolume(){
      return thePi * radius * radius * height;
   }

   //Finds volume of a pyramid
   double pyramidVolume(){
      return length * width * height / 3;
   }
}

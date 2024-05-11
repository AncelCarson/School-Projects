/* Program Written for CSII
   In Class 2
   Program written by Ancel Carson
   29/2/18
   Windows 10
   Atom and Command Line
   Program designed to test Shapes file
*/

public class ShapesTest{
   public static void main(String[] args){

      //Declare Variables
      Shapes shape1 = new Shapes();
      Shapes shape2 = new Shapes(3.5, 5);
      Shapes shape3 = new Shapes(10.75, 9.123);

      //Output variables
      System.out.printf("The value of pi is %.4f\n",Shapes.thePi);

      //Output Statements
      System.out.printf("Shape1's radius is %.4f ",shape1.radius);
      System.out.printf("and it's height is %.4f\n",shape1.height);
      System.out.printf("The cone volume of shape1 is %.4f\n",shape1.coneVolume());
      System.out.printf("The cylinder volume of shape1 is %.4f\n",shape1.cylinderVolume());
      System.out.printf("Shape2's radius is %.4f ",shape2.radius);
      System.out.printf("and it's height is %.4f\n",shape2.height);
      System.out.printf("The cone volume of shape2 is %.4f\n",shape2.coneVolume());
      System.out.printf("The cylinder volume of shape2 is %.4f\n",shape2.cylinderVolume());
      System.out.printf("Shape3's radius is %.4f ",shape3.radius);
      System.out.printf("and it's height is %.4f\n",shape3.height);
      System.out.printf("The cone volume of shape3 is %.4f\n",shape3.coneVolume());
      System.out.printf("The cylinder volume of shape3 is %.4f\n",shape3.cylinderVolume());
   }
}

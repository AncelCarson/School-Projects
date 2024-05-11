/* Program Written for personal use
   Function file
   Program written by Ancel Carson
   9/2/18
   Windows 10
   Atom and Command Line
   Holding file for all functions
*/

public class MyFunct{

   //A simple exponent function
   public static float intPow(float num1, int num2){
      float result = 1;
      for(int i = 1; i <= num2; i++){
         result = result * num1;
      }
      return result;
   }
}

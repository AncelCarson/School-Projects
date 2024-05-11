/* Program Written for CSII
   Program Test 1
   Program written by Ancel Carson
   31/1/18
   Windows 10
   Atom and Command Line
   Program is designed to test the break function
*/

public class BreakTest{
   public static void main(String[] args){
      for(int i=0;i<1;i++){
         for(int j=0;j<20;j++){
            for(int k=0;k<20;k++){
               if(k == 10){
                  break;
               }
               if(j == 10){
                  continue;
               }
               System.out.println(i+" "+j+" "+k);
            }
         }
      }
   }
}

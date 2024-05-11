/* Program Written for CSII
   Assignment 9
   Program written by Ancel Carson
   11/4/18
   Windows 10
   Atom and Command Line
   This progeam serves as a stop watch for any program.
*/

public class StopWatch{
   private long startTime, endTime;

   StopWatch(){
      startTime = 0;
      endTime = 0;
   }

   public void start(){
      startTime = System.currentTimeMillis();
   }

   public void stop(){
      endTime = System.currentTimeMillis();
   }

   public long getElapsedTime(){
      return endTime - startTime;
   }
}

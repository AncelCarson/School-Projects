/**
*  @author Ancel Carson
*  Assignment 9 CS2
*  3/10/18
*  Windows 10
*  Atom and Command Line
*  This program serves as a stop watch for any program.
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

   public long currentElapsedTime(){
      return System.currentTimeMillis() - startTime;
   }
}
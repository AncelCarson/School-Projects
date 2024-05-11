/**
 * @author Jacob Kelsey
 * COSC 2203 - Data Structures
 * Assignment 8
 * Date: Oct 20, 2018
 * Coding Time: 0:20
 * OS: Windows 10
 * IDE: NetBeans
 * This class is the stopwatch class for the hospital simulator group project
 */

public class StopWatchSec {
    private long startTime;
    private long endTime;
    private boolean isRunning;

    StopWatchSec() {
    }

   public void start() {
      startTime = cTime();
      isRunning = true;
   }

   public void stop() {
      endTime = cTime();
      isRunning = false;
   }

   public long getElapsedTime() {
      if(isRunning)
         endTime = cTime();
      return endTime - startTime;
   }

   private long cTime() {
      return System.currentTimeMillis()/1000;
   }
}
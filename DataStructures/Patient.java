/**
 * @author Jacob Kelsey
 * @author Ancel Carson
 * COSC 2203 - Data Structures
 * Assignment 8
 * Date: Oct 20, 2018
 * Coding Time: 2:00
 * OS: Windows 10
 * IDE: NetBeans, Atom
 * This class is the patient class for the hospital simulator group project
 */

public class Patient {
   //All times are in simulation minutes (real time seconds)
   private static final double[] rateChance = {0, .20, .30, .40, .10};   //Probability of new patient being of severity [0-x] (make sure these add to 1)
   private static int totalPatientNum = 0;         //The total number of patients created

   private StopWatchSec waitTime = new StopWatchSec();   //Time spent waiting before roomed
   private StopWatchSec roomTime = new StopWatchSec();   //Time spent in room
   private int rating, roomTimer;  //Severity rating, Amount of time patient will spend in a room


   /**
    * Default constructor
    */
   Patient() {
      setRating();
      setRoomTimer();
      totalPatientNum++;
      waitTime.start();
   }

   /**
    * Constructor for creating empty patients
    * @param createNew  Unused boolean the gives constructor a different address
    */
   Patient(boolean createNew) {
      this.rating = 0;
      this.roomTimer = 0;
      roomTime.start();
   }

   /**
    * Constructor for debugging
    * @param rating What rating the new patient should be
    */
   Patient(int rating) {
      this.rating = rating;
      setRoomTimer();
      totalPatientNum++;
      waitTime.start();
   }

   /**
    * Constructor for debugging
    * @param rating    What rating the new patient should be
    * @param roomTimer What the room timer should be set to
    */
   Patient(int rating, int roomTimer) {
      this.rating = rating;
      this.roomTimer = roomTimer;
      totalPatientNum++;
      waitTime.start();
   }

   /**
    * Place the patient in a room
    */
   public void room() {
      waitTime.stop();
      roomTime.start();
   }


   /**
    * Returns the priority rating of the patient
    * @return  The priority rating of the patient
    */
   public int getRating() {
      return rating;
   }

   /**
    * Returns the priority based off wait time
    * @return  Priority
    */
   public double getPriority(){
      return rating*getWait();
   }

   /**
    * Returns the time that patient has been waiting in seconds
    * @return  Time spent waiting in lobby
    */
   public double getWait() {
      return waitTime.getElapsedTime();
   }

   /**
    * Returns the time the patient has spent in the room thus far in seconds
    * @return  Time spent in room
    */
   public double getRoomTime() {
      return roomTime.getElapsedTime();
   }

   /**
    * Checks the time spent in a room vs. the room timer
    * @return  True if time is up, False otherwise
    */
   public boolean checkRoomTimer() {
      if(roomTime.getElapsedTime() >= roomTimer) {
         roomTime.stop();
         return true;
      } else return false;
   }

   /**
    * Returns the total number of patients created up to this point
    * @return  Total number of patients
    */
   public int getPatientNum() {
      return totalPatientNum;
   }


   /**
    * Randomly assigns a rating to this patient
    * @return  The rating of this patient (returns zero if outside of probability range)
    */
   private void setRating() {
      double rand = Math.random();
      for(int i = 0; i < rateChance.length; i++) {
         if(rand < rateChance[i]) {
            rating = i;
            break;
         } else rand -= rateChance[i];
      }
   }

   /**
    * Returns the time that the patient will occupy a room
    * @return  Time to be spent in room
    */
   private void setRoomTimer() {
      switch(rating) {        //Sets roomTimer based on priority rating
         case 1:
            roomTimer = 30;
            break;
         case 2:
            roomTimer = 45;
            break;
         case 3:
            roomTimer = 60;
            break;
         case 4:
            roomTimer = 20;
            break;
         default:
            roomTimer = 0;
      }

      if(Math.random() < .20)     //20% chance of extra time
         roomTimer += roomTimer*Math.random()/2;   //Add up to 50% more time
   }
}
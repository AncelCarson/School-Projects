/**
*  @author Ancel Carson
*  @author Spencer Davis
*  Assignment 8
*  20/10/18
*  Total Time Worked: 3:00
*  Windows 10
*  VisualStudios, Atom, and Command Line
*  Program that runs a simulation of a 10 hour hospital rush
*/

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.InputMismatchException;
public class ERSimulator{
   public static void main(String[] args){
      int randomTimeDelay = 0,  //Time between Patients entering hospital
         userChoice = 0,        //Number of rooms that are available during the simulation
         closeWait = 0,         //Number of Patients waiting at close
         totalWaiting = 0;      //Number of Patients waiting at any time
      int[] wait = new int[4],  //Total wait time of Patients per queue
         close = new int[4],    //Number of Patiants waiting at close per queue
         nums = new int[4];     //Number of Patients roomed per queue
      boolean check = true,     //If the program is still running of not
         morePatients = true;   //If the program is Still creating Patients
      Patient[] room = null;    //Rooms available to hold patients
      Scanner theInput = new Scanner(System.in);    //Scanner to recieve input
      StopWatchSec openHours = new StopWatchSec();  //Stopwatch that times hol long program runs

      //Creating Queue of type LinkedList to hold waiting Patients
      Queue<Patient>[] rating = new Queue[4];
      for(int i = 0; i < rating.length; i++){
         rating[i] = new LinkedList();
      }

      //Asks for user to enter how many rooms will ba available
      System.out.println("Please enter how many rooms you want to simulate.");
      System.out.println("This number should be between 1 and 10.");
      try{
         userChoice = theInput.nextInt();
         if(userChoice < 1 || userChoice > 10){
            System.out.println("You number must be between 1 and 10.");
            System.out.println("Please enter how many rooms you want to simulate.");
            userChoice = theInput.nextInt();
         }
      }

      //Catches if the inpu is not an integer value
      catch(InputMismatchException e1){
         System.out.println("Input must be an integer value less than 10.");
         System.exit(1);
      }

      //Sets room length to the  users choice
      room = new Patient[userChoice];

      //Fills Rooms with empty patents so there are no null values
      for (int i = 0; i < userChoice; i++){
         room[i] = new Patient(true);
      }
      openHours.start();         //Starts Timer signialing beginning of simulation

      //Main loop that drives program
      while(check){

         //Creates new patient at the correct interval
         randomTimeDelay = getPatient(morePatients, openHours, randomTimeDelay, rating);

         //Sorts patients into the an open room based off priority
         sortPatient(room, rating, wait, nums);

         //Checks if the program has been running for more than 10 munites
         if(openHours.getElapsedTime() >= 600){

            //Checks if more Patients are being created
            if(morePatients){

               //Sets close value to length of each queue at close
               close[0] = rating[0].size();
               close[1] = rating[1].size();
               close[2] = rating[2].size();
               close[3] = rating[3].size();

               //Runs output that displays after 10 minutes is up
               //midOutput(close, wait, nums, room);

               //Sets closeWait value to total size of all queues
               closeWait = rating[0].size() + rating[1].size() + rating[2].size() + rating[3].size();
            }
            morePatients = false;      //Say no more patients will be created
         }

         //Sets totalWait value to total size of all per loop
         totalWaiting = rating[0].size() + rating[1].size() + rating[2].size() + rating[3].size();

         //Checks that time is up and no more patients are waiting
         if(morePatients == false && totalWaiting == 0){
            check = false;          //tells main loop to end
            openHours.stop();       //Stops timer for program
         }
      }

      //Restates mid output
      midOutput(close, wait, nums, room);

      //Output that dislays at the end of the program
      System.out.printf("\nIt took %.2f hours ", ((float)openHours.getElapsedTime() / 60.0) - 10.0);
      System.out.printf("to room all %d patients that remained in the lobby\n", closeWait);
      System.out.println("Simulatin has been completed\n");
   }

   /**
   * Creates new Patient and adds it to the appropriate queue
   * @param morePatients      A boolean value that is set to true is has not been 10 minutes
   * @param openHours         StopWatchSec that times how long the program has been running
   * @param randomTimeDelay   Integer value that equals how many seconds are between patients
   * @param rating            Queue that holds all patients in the wating room
   * @return                  Time to wait before creating the next patient
   */
   static int getPatient(boolean morePatients, StopWatchSec openHours, int randomTimeDelay, Queue<Patient>[] rating){

      //Checks that more patients are being created
      if (morePatients){

         //checks that the enough time has passed between patients
         if (openHours.getElapsedTime() >= randomTimeDelay){
            Patient newPatient = new Patient();          //Creates new Patient

            //outputs that a patient entered the room
            System.out.printf("Patient %d entered waiting room\n", newPatient.getPatientNum());
            switch(newPatient.getRating()){              //Assigns Patient to queue based on rating
               case 1: rating[0].add(newPatient); break;
               case 2: rating[1].add(newPatient); break;
               case 3: rating[2].add(newPatient); break;
               case 4: rating[3].add(newPatient); break;
            }

            //Sets new time between patients
            randomTimeDelay = getRandomTime() + (int)(openHours.getElapsedTime());
         }
      }
      return randomTimeDelay;    //Returns time to wait
   }

   /**
   * Gets the amount of time between patients
   * @return         random integer from 0 to 15
   */
   static int getRandomTime(){
      return (int)(Math.random() * 15);   //returns value 0-15
   }

   /**
   * Places Patient in the next available room based off priority
   * @param room     Patient array that acts as open hospital rooms
   * @param rating   Queue that holds all Patients in the waiting room
   * @param wait     Integer array that holds total amount of time every rating spend waiting
   * @param nums     Integer array that holds totaal number of Patients roomed per rating
   */
   static void sortPatient(Patient[] room, Queue<Patient>[] rating, int[] wait, int[] nums){
      int patientRating = 0;           //Rating of patient with highest priority
      boolean patientAdded = false;    //Says if a patient was added to a room

      //Runs for a number of times equal to the number of rooms
      for(int i = 0; i < room.length; i++){

         //Checks if a room has errored to null
         if(room[i] == null){
            room[i] = new Patient(true);  //Sets null room to an empty patient
         }

         //Checks if current room is empty
         if(room[i].checkRoomTimer()){

            //Outputs if a patient is leaving a room
            if(room[i].getPatientNum() != 0){
               System.out.printf("<--Patient %d has left room %d\n", room[i].getPatientNum(), i + 1);
               room[i].removePatient();
            }

            //Places rating 4 Patient into a room if one is waiting
            if(rating[3].size() > 0){
               room[i] = rating[3].poll();   //Removes Patient rom queue and places in room
               patientAdded = true;          //Says Patient was added
            }

            //Checks if Patients are waiting in queue 1, 2, or 3
            else if(rating[0].size() > 0 || rating[1].size() > 0 || rating[2].size() > 0){

               //Selects queue with highest priority
               switch(getPriority(rating[0].peek(), rating[1].peek(), rating[2].peek())){
                  case 1:
                     room[i] = rating[0].poll();   //Removes Patient rom queue and places in room
                     break;
                  case 2:
                     room[i] = rating[1].poll();   //Removes Patient rom queue and places in room
                     break;
                  case 3:
                     room[i] = rating[2].poll();   //Removes Patient rom queue and places in room
                     break;
               }
               patientAdded = true;                //Says Patient was added
            }

            //Makes sure room was not set to null
            if(room[i] != null){

               //Checks that a Patient was added
               if(patientAdded){

                  //Outputs that a patient has entered a room
                  System.out.printf("-->Patient %d has entered room %d\n", room[i].getPatientNum(), i + 1);

                  //Tells Patient it has been roomed
                  room[i].room();

                  //Retrieves rating of Patient in current room
                  patientRating = room[i].getRating();

                  //Adds wait of current patient to total for that rating
                  wait[patientRating - 1] = wait[patientRating - 1] + (int)room[i].getWait();

                  //Increases count of patients of rating type roomed
                  nums[patientRating - 1]++;

                  //Says Patient has been delt with
                  patientAdded = false;
               }
            }
         }
      }
   }

   /**
   * Finds the Patient with the highest priority out of the first three queues
   * @param pat1  Patient waiting the longest in the rating 1 queue
   * @param pat2  Patient waiting the longest in the rating 2 queue
   * @param pat3  Patient waiting the longest in the rating 3 queue
   * @return      Integer that corelates to rating with the highest priority
   */
   static int getPriority(Patient pat1, Patient pat2, Patient pat3){
      int priority = 3;          //Default priority
      double priority1 = 0,      //Priority value of Patient 1
      priority2 = 0,             //Priority value of Patient 2
      priority3 = 0;             //Priority Value of Patient 3

      //If Statements catch if No Patient was given
      if(pat1 != null){
         priority1 = pat1.getPriority();  //Sets priority value of Patient 1
      }
      if(pat2 != null){
         priority2 = pat2.getPriority();  //Sets priority value of Patient 2
      }
      if(pat3 != null){
         priority3 = pat3.getPriority();  //Sets priority value of Patient 3
      }

      //Logic for determining which Patient has highest priority
      if(priority2 > priority3){
         priority = 2;                    //Sets Priority to queue 2
         if(priority1 > priority2){
            priority = 1;                 //Sets proirity to queue 1
         }
      }
      if(priority1 > priority3){
         priority = 1;                    //Sets priority to queue 1
         if(priority2 > priority1){
            priority = 2;                 //Sets proiority to queue 2
         }
      }
      return priority;                    //Returns queue with highest priority
   }

   /**
   * Output that displays after 10 hours
   * @param close    Integer array that holds number of patients wating at close per queue
   * @param wait     Integer array that holds total amount of time every rating spend waiting
   * @param nums     Integer array that holds totaal number of Patients roomed per rating
   * @param room     Patient array that acts as open hospital rooms
   */
   static void midOutput(int[] close, int[] wait, int[] nums, Patient[] room){
      int emptyRooms = 0;                    //Value that holds how many empty rooms there are
      System.out.println("After 10 hours:");

      //Displays number of patients currently waiting per queue
      System.out.printf("\t%d patients of rating 1 were left.\n", close[0]);
      System.out.printf("\t%d patients of rating 2 were left.\n", close[1]);
      System.out.printf("\t%d patients of rating 3 were left.\n", close[2]);
      System.out.printf("\t%d patients of rating 4 were left.\n\n", close[3]);

      //If statements catch if no patient of a certain type was roomed
      if(nums[0] == 0){
         System.out.println("No rating 1 patients were roomed.");
      }
      else{
         System.out.printf("Average wait time for rating 1: %d minutes.\n", wait[0] / nums[0]);
      }
      if(nums[1] == 0){
         System.out.println("No rating 2 patients were roomed.");
      }
      else{
         System.out.printf("Average wait time for rating 2: %d minutes.\n", wait[1] / nums[1]);
      }
      if(nums[2] == 0){
         System.out.println("No rating 3 patients were roomed.");
      }
      else{
         System.out.printf("Average wait time for rating 3: %d minutes.\n", wait[2] / nums[2]);
      }
      if(nums[3] == 0){
         System.out.println("No rating 4 patients were roomed.");
      }
      else{
         System.out.printf("Average wait time for rating 4: %d minutes.\n", wait[3] / nums[3]);
      }

      //Checks if there are any empty rooms and displays value
      for (int i = 0; i < room.length; i++) {
         if(room[i].checkRoomTimer()){
            emptyRooms++;
         }
      }
      System.out.printf("%d rooms are empty.\n", emptyRooms);
   }
}
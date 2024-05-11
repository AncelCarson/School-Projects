/**
*  @author Ancel Carson
*  Assignment 4
*  25/9/18
*  Total Time Worked: 1:35
*  Windows 10
*  Atom and Command Line
*  Run through all of the methods in the LinkedList class
*/

public class LinkedListDriver{

   /**
   * Main driving method that runs the check of the LinkedList class
   * @param myList         LinkedList object from file given by Dr.Rouse
   */
   public static void main(String[] args){

      //Declare Variables
      MyLinkedList myList = new MyLinkedList();

      //Checking if array is empty
      System.out.println("\nChecking if Linked list is empty");
      if(myList.isEmpty()){                  //checking if list is empty
         System.out.println("\tLinkedList is empty");
      }
      else{
         System.out.println("\tLinkedList is not empty");
      }

      //Adding information the the beginning of the list
      System.out.println("\nAdding \"node3\", \"node2\", and \"node3\" to the first nodes");
      myList.insertAtStart("node 3");        //inserting data in first node
      myList.insertAtStart("node 2");        //inserting data in first node
      myList.insertAtStart("node 1");        //inserting data in first node

      //Checking that nodes were made properly
      System.out.println("\nChecking if Linked list contains 3 nodes");
      if(!myList.isEmpty()){                 //checking if list is not empty
         System.out.println("\tLinkedList is empty");
      }
      else{
         System.out.println("\tLinkedList is not empty");
      }
      System.out.println("\nRetriving list length");
      System.out.printf("\tList length is %d\n", myList.getSize());
         //displaying list size
      System.out.println("\nRetrieving information in nodes");
      System.out.printf("\tIn node 1 is \"%s\"\n", myList.start.getData());
         //Retrieving data from node 1
      System.out.printf("\tIn node 2 is \"%s\"\n", myList.start.getLink().getData());
         //Retrieving data from node 2
      System.out.printf("\tIn node 3 is \"%s\"\n", myList.start.getLink().getLink().getData());
         //Retrieving data from node 3

      //Removing information from list
      System.out.println("\nRemoving node 2 from the list");
      myList.deleteAtPos(2);                 //deleting node 2
      System.out.println("\nRetriving list length");
      System.out.printf("\tList length is %d\n", myList.getSize());
         //displaying list size
      System.out.println("\nRetrieving information in nodes");
      System.out.printf("\tIn node 1 is \"%s\"\n", myList.start.getData());
         //Retrieving data from node 1
      System.out.printf("\tIn node 2 is \"%s\"\n", myList.start.getLink().getData());
         //Retrieving data from node 2
      System.out.println("\nRemoving node 2 from the list");
      myList.deleteAtPos(2);                 //deleting node 2
      System.out.println("\nRetriving list length");
      System.out.printf("\tList length is %d\n", myList.getSize());
         //displaying list size

      //Adding information at the end of the List
      System.out.println("\nAdding \"node 3\" to the end of the list");
      myList.insertAtEnd("node 3");          //adding data to the end of the list
      System.out.println("\nRetriving list length");
      System.out.printf("\tList length is %d\n", myList.getSize());
         //displaying list size
      System.out.println("\nRetrieving information in nodes");
      System.out.printf("\tIn node 1 is \"%s\"\n", myList.start.getData());
         //Retrieving data from node 1
      System.out.printf("\tIn node 2 is \"%s\"\n", myList.start.getLink().getData());
         //Retrieving data from node 2

      //Adding information to the middle of the list
      System.out.println("\nAdding \"node 2\" to the middle of the list");
      myList.insertAtPos("node 2", 2);       //adding data in node 2
      System.out.println("\nRetriving list length");
      System.out.printf("\tList length is %d\n", myList.getSize());
         //displaying list size
      System.out.println("\nRetrieving information in nodes");
      System.out.printf("\tIn node 1 is \"%s\"\n", myList.start.getData());
         //Retrieving data from node 1
      System.out.printf("\tIn node 2 is \"%s\"\n", myList.start.getLink().getData());
         //Retrieving data from node 2
      System.out.printf("\tIn node 3 is \"%s\"\n", myList.start.getLink().getLink().getData());
         //Retrieving data from node 3

      //Removing information from the beginning of the list
      System.out.println("\nRemoving node 1 from the list");
      myList.deleteAtPos(1);                 //deleting node 1
      System.out.println("\nRetriving list length");
      System.out.printf("\tList length is %d\n", myList.getSize());
         //displaying list size
      System.out.println("\nRetrieving information in nodes");
      System.out.printf("\tIn node 1 is \"%s\"\n", myList.start.getData());
         //Retrieving data from node 1
      System.out.printf("\tIn node 2 is \"%s\"\n", myList.start.getLink().getData());
         //Retrieving data from node 2

      //Running end of program statements
      System.out.println("Program has been completed");
      System.out.println("LinkedList class working properly\n");
   }
}
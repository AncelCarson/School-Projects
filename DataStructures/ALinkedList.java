/**
*  @author Dr. Rouse
*  @author Ancel Carson
*  Assignment 4
*  25/9/18
*  Total Time Worked: 1:10+
*  Windows 10
*  Atom and Command Line
*  Linked List class used in place of jave defined Linked List
*/
class ALinkedList
{
   /**
   * No main method as this class is used to make Node objects
   * @param start    Reference for fisrt node in sequence
   * @param end      Reference for last node in sequence
   * @param size     Size of linked lst
   */
   protected ANode start;        //creates an empty node
   protected ANode end;          //creates an empty node
   public int size;              //creates an empty int

   /**
   * Default constructor that creates a linked list object
   * @param start    Reference of first node in created linked list
   * @param end      Reference of last node in created linked list
   * @param size     Size of created linked list
   */
   public ALinkedList()
   {
      start = null;        //sets start reference to null
      end = null;          //sets end reference to null
      size = 0;            //sets initial length to 0
   }

   /**
   * Returs a true or false value if list is empty or not
   * @param start    First node in linked list
   * @return         True if start is null and False if start is full
   */
   public boolean isEmpty()
   {
      return start == null;         //check if start is null
   }

   /**
   * Returns size of the current linked list
   * @param size     How many nodes make up the linked list
   * @return         Int length of the linked list
   */
   public int getSize()
   {
      return size;         //returns length of the linked list
   }

   /**
   * Adds a node at the beginning of the linked list
   * @param val      Given string to be put inside of the created node
   * @param nptr     Node that is being added to the list
   * @param size     How many nodes are in the linked list
   * @param start    The node at the start of the linked list
   * @param end      The node at the end of the linked list
   */
   public void insertAtStart(String val)
   {
      ANode nptr = new ANode(val, null);  //creates a new node with given string
      size++ ;                            //increases the size variable by 1
      if(start == null)                   //checks to see if start is empty
      {
         start = nptr;                    //sets start to created node
         end = start;                     //sets end to created node
      }
      else
      {
         nptr.setLink(start);             //linkes previous starting node to new starting node
         start = nptr;                    //sets start to created node
      }
   }

   /**
   * Adds a node to the end of the linked list
   * @param val      Given string to be put inside of the created node
   * @param nptr     Node that is being added to the linked list
   * @param size     How any nodes are in the linked list
   * @param start    The node at the start of the linked list
   * @param end      The node at the end of the linked list
   */
   public void insertAtEnd(String val)
   {
      ANode nptr = new ANode(val,null);   //creates a new node with given string
      size++ ;                            //increases the size variable by 1
      if(start == null)
      {
         start = nptr;                    //sets start to created node
         end = start;                     //sets end to created node
      }
      else
      {
         end.setLink(nptr);               //links current end node to created node
         end = nptr;                      //sets end to created node
      }
   }

   /**
   * Adds a node to the linked list at a specified location
   * @param val      Given string to be put inside of the created node
   * @param pos      Where the created node should be positioned
   * @param nptr     Node that is being added to the linked list
   * @param ptr      Reference that holds node before the desired position
   * @param tmp      Reference that holds node after the desired position
   * @param size     How many nodes are in the linked list
   */
   public void insertAtPos(String val , int pos)
   {
      ANode nptr = new ANode(val, null);  //creates a new node with given string
      ANode ptr = start;                  //sets working node reference at start
      pos = pos - 1 ;                     //shifts pos back by 1
      for (int i = 1; i < size; i++)      //for loop through length of list
      {
         if (i == pos)                    //checks if at correct node
         {
            ANode tmp = ptr.getLink();    //sets temp node to node after pos
            ptr.setLink(nptr);            //sets reference of node before pos to nptr
            nptr.setLink(tmp);            //sets reference of nptr to tmp

            break;                        //ends for loop
         }
         ptr = ptr.getLink();             //shifts working node down list
      }
      size++ ;                            //increases the size variable by 1
   }

   /**
   * Removes the node at a specified position from the linked list
   * @param pos      Position of node to be deleted
   * @param start    The node at the start of the linked list
   * @param size     How many nodes are in the linked list
   * @param s        Reference that holds last node to be deleted
   * @param t        Reference of node to become the last node
   * @param end      The node at the end of the linked list
   * @param ptr      Reference that holds node before the desired position
   * @param tmp      reverence that holds node after the desired position`
   */
   public void deleteAtPos(int pos)
   {
      if (pos == 1)                       //checks if desired position is first node in list
      {
         start = start.getLink();         //shifts start node down list by 1
         size--;                          //decreases the size variable by 1
         return ;                         //ends method
      }
      if (pos == size)                    //chacks if desired position is last node in list
      {
         ANode s = start;                 //sets working node1 reference at start
         ANode t = start;                 //sets working node2 reference at start
         while (s != end)                 //runs while not at the end of the linked list
         {
            t = s;                        //sets working node1 to working node2
            s = s.getLink();              //shifts working node1 down list by 1
         }
            end = t;                      //sets end to working node2
            end.setLink(null);            //makes end reference null
            size --;                      //decreases the size variable by 1
            return;                       //ends method
      }
      ANode ptr = start;                  //sets working node reference at start
      pos = pos - 1 ;                     //shifts pos back by 1
      for (int i = 1; i < size - 1; i++)  //for loop through length of list
      {
         if (i == pos)                    //checks if at correct node
         {
            ANode tmp = ptr.getLink();    //sets tmp node to node after pos
            tmp = tmp.getLink();          //shifts tmp node down 1
            ptr.setLink(tmp);             //sets wroking node reference to tmp
            break;                        //ends cor loop
         }
         ptr = ptr.getLink();             //shifts working node down list
      }
      size-- ;                            //decreases the size variable by 1
   }
}

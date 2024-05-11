/**
*  @author Dr. Rouse
*  @author Ancel Carson
*  Assignment 4
*  25/9/18
*  Total Time Worked: 40 min +
*  Windows 10
*  Atom and Command Line
*  Creates nodes that are used in th linked list object
*/
class ANode
{
   /**
   * No main method as this class is used to make Node objects
   * @param link     Reference that allows nodes to connect to each other
   * @param data     String of data that is held inside of the node
   */
    protected String data;    //creates an empty String
    protected ANode link;     //creates an empty node

    /**
    * Default constructor that is called when a new series of nodes is needed
    * @param link    Null value because it is the first in the series and has nothing to reference yet
    * @param data    Blank string as data is not needed in the reference node
    */
    public ANode()
    {
        link = null;          //sets node reference to null
        data = "";            //assigns string an ampty value
    }

    /**
    * Constructor to create a node with information and a link to another node
    * @param d       String given by another program
    * @param n       Reference of anothe node given by another program
    * @param data    String that node conatins
    * @param link    Node that current node has a reference to
    */
    public ANode(String d,ANode n)
    {
        data = d;             //assigns node string to given string
        link = n;             //sets node link to given node reference
    }

    /**
    * Changes node that current node is referencing
    * @param n       Reference of anothe node given by another program
    * @param link    Containes reference to another node
    */
    public void setLink(ANode n)
    {
        link = n;             //sets node ling to given node reference
    }

    /**
    * Changes data that is stored in current node
    * @param d       String given by another program
    * @param data    String that is contained in current node
    */
    public void setData(String d)
    {
        data = d;             //assigns node string to given string
    }

    /**
    * Returnes the reference to another node contained in current node
    * @param link    Containes reference to another node
    * @return        Returns node that current node references to another program
    */
    public ANode getLink()
    {
        return link;          //returns node reference
    }

    /**
    * Returns data that is stored in the current node
    * @param data    String that is contained in current node
    * @return        Returns the string contained in current node to another program
    */
    public String getData()
    {
        return data;          //returns string in current node
    }
}

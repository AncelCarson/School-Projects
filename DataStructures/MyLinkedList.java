class MyLinkedList
{
    protected MyNode start;
    protected MyNode end ;
    public int size ;

    public MyLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return start == null;
    }
    public int getSize()
    {
        return size;
    }
    public void insertAtStart(String val)
    {
        MyNode nptr = new MyNode(val, null);
        size++ ;
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.setLink(start);
            start = nptr;
        }
    }
    public void insertAtEnd(String val)
    {
        MyNode nptr = new MyNode(val,null);
        size++ ;
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    public void insertAtPos(String val , int pos)
    {
        MyNode nptr = new MyNode(val, null);
        MyNode ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++)
        {
            if (i == pos)
            {
                MyNode tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);

                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    public void deleteAtPos(int pos)
    {
        if (pos == 1)
        {
            start = start.getLink();
            size--;
            return ;
        }
        if (pos == size)
        {
            MyNode s = start;
            MyNode t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        MyNode ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++)
        {
            if (i == pos)
            {
                MyNode tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
    }
}

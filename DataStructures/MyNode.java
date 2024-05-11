class MyNode
{
    protected String data;
    protected MyNode link;

    public MyNode()
    {
        link = null;
        data = "";
    }
    public MyNode(String d,MyNode n)
    {
        data = d;
        link = n;
    }
    public void setLink(MyNode n)
    {
        link = n;
    }
    public void setData(String d)
    {
        data = d;
    }
    public MyNode getLink()
    {
        return link;
    }
    public String getData()
    {
        return data;
    }
}

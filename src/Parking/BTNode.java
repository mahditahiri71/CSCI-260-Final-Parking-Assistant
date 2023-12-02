package Parking;
/* Class BTNode */
class BTNode
{
    BTNode left, right;
    public String[] data;
    /* Constructor */
    public BTNode()
    {
        left = null;
        right = null;
        data = new String[2];
    }
    /* Constructor */
    public BTNode(String[] n)
    {
        left = null;
        right = null;
        data = n;
    }
    /* Function to set left node */
    public void setLeft(BTNode n)
    {
        left = n;
    }
    /* Function to set right node */
    public void setRight(BTNode n)
    {
        right = n;
    }
    /* Function to get left node */
    public BTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(String[] d)
    {
        data = d;
    }
    /* Function to get data from node */
    public String[] getData()
    {
        return data;
    }
    /* Function to get position from data */
    public String getPos() 
    {
        return data[0];
    }
    /* Function to get person from data */
    public String getPerson() 
    {
        return data[1];
    }
}
package Parking;


/* Class BT */
class BT
{
    private BTNode root;
    /* Constructor */
    public BT()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Functions to insert String[] data */
    public void insert(String[] data)
    {
        root = insert(root, data);
    }
    /* Function to insert data recursively in order respect to the node */
    private BTNode insert(BTNode node, String[] data) {
        if (node == null)
            node = new BTNode(data);
        else
        {
            int compareResult = data[0].compareTo(node.getPos());
            if (compareResult >= 0)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    /* Function to search and return person's name for an element */
    public String search(String pos)
    {
        return search(root, pos);
    }
    /* Function to search for an element recursively */
    private String search(BTNode r, String val)
    {
        if (r.getPos().equals(val))
            return r.getPerson();
        else if (r.getPos().compareTo(val) > 0)
            return search(r.getLeft(), val);
        else if (r.getPos().compareTo(val) < 0)
            return search(r.getRight(), val);
        else
            return null;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(BTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getPerson() +" ");
            inorder(r.getRight());
        }
    }
}
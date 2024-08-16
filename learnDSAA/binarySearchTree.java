package Personal.Learning.learnDSAA;

public class binarySearchTree
{
    node2 root;
    public void insert(node2 node)
    {
        root = insertHelper(root, node);
    }
    private node2 insertHelper(node2 root, node2 node)
    {
        int data = node.data;
        if(root == null)
        {
            root = node;
            return root;
        }
        else if(data < root.data)
        {
            root.left = insertHelper(root.left, node);
        }
        else
        {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }
    public void display()
    {
        displayHelper(root);
    }
    private void displayHelper(node2 root)
    {
        if(root != null)
        {
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
            //swap root.left .right for descreasing order
        }
    }
    public boolean search(int data)
    {
        return searchHelper(root, data);
    }
    private boolean searchHelper(node2 root, int data)
    {
        if(root == null)
        {
            return false;
        }
        else if(root.data == data)
        {
            return true;
        }
        else if(root.data > data)
        {
            return searchHelper(root.left, data);
        }
        else
        {
            return searchHelper(root.right, data);
        }
    }
    public void remove(int data)
    {
        if(search(data))
        {
            removeHelper(root, data);
        }
        else
        {
            System.out.println(data + " not found");
        }
    }
    public node2 removeHelper(node2 root, int data)
    {
        if(root == null)
        {
            return root;
        }
        else if(data < root.data)
        {
            root.left = removeHelper(root.left, data);
        }
        else if(data > root.data)
        {
            root.right = removeHelper(root.right, data);
        }
        else
        {
            if(root.left == null && root.right == null)
            {
                root = null;
            }
            else if(root.right != null)
            {
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            }
            else
            {
                root.data = predeccessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }
    private int successor(node2 root) //least val below right child of root
    {
        root = root.right;
        while(root.left != null)
        {
            root = root.left;
        }
        return root.data;
    }
    private int predeccessor(node2 root) //greatest val below left child of root
    {
        root = root.left;
        while(root.right != null)
        {
            root = root.right;
        }
        return root.data;
    }
}
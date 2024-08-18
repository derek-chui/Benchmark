package Personal.Projects.Benchmark.learnDSAA;
import java.util.*;

public class graph2
{
    ArrayList<LinkedList<node>> alist;

    graph2()
    {
        alist = new ArrayList<>();
    }
    public void addNode(node node)
    {
        LinkedList<node> currentList = new LinkedList<>();
        currentList.add(node);
        alist.add(currentList);
    }
    public void addEdge(int src, int dst)
    {
        LinkedList<node> currentList = alist.get(src);
        node dstNode = alist.get(dst).get(0);
        currentList.add(dstNode);
    }
    public boolean checkEdge(int src, int dst)
    {
        LinkedList<node> currentList = alist.get(src);
        node dstNode = alist.get(dst).get(0);
        for(node node : currentList)
        {
            if(node == dstNode) return true;
        }
        return false;
    }
    public void print()
    {
        for(LinkedList<node> currentList : alist)
        {
            for(node node : currentList)
            {
                System.out.print(node.data + " -> ");
            }
            System.out.println();
        }
    }
}

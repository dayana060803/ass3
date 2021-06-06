package Ass4;
import java.io.*;
import java.util.*;
class Graph
{
    private int num;
    private LinkedList<Integer> arr[];
    Graph(int num)
    {
        num = num;
        arr = new LinkedList[num];
        for (int i=0; i<num; ++i)
            arr[i] = new LinkedList();
    }
    void edgeAdd(int num,int num2)
    {
        arr[num].add(num2);
    }
    void BreadthFirstSearch(int num3)
    {
        boolean newn[] = new boolean[num];
        LinkedList<Integer> line = new LinkedList<Integer>();
        newn[num3]=true;
        line.add(num3);
        while (line.size() != 0)
        {
            num3 = line.poll();
            System.out.print(num3+" ");
            Iterator<Integer> i = arr[num3].listIterator();
            while (i.hasNext())
            {
                int x = i.next();
                if (!newn[x])
                {
                    newn[x] = true;
                    line.add(x);
                }
            }
        }
    }
    public static void main(String args[])
    {
        Graph y = new Graph(4);
        y.edgeAdd(0, 1);
        y.edgeAdd(0, 2);
        y.edgeAdd(1, 2);
        y.edgeAdd(2, 0);
        y.edgeAdd(3, 3);
        y.edgeAdd(3, 3);
        System.out.println("vertex is 2");
        y.BreadthFirstSearch(2);
    }
}
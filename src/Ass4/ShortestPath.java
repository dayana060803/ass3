package Ass4;
import java.util.LinkedList;
public class ShortestPath
{
    static class Edge
    {
        int x;
        int y;
        int z;
        public Edge(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Graph
    {
        int num;
        LinkedList<Edge> [] arr;
        Graph(int num) {
            this.num = num;
            arr = new LinkedList[num];
            for (int i=0; i <num ; i++)
            {
                arr[i] = new LinkedList<>();
            }
        }
        public void edgeAdd(int x, int y, int z)
        {
            Edge edge = new Edge(x, y, z);
            arr[x].addFirst(edge);
        }
        public void printGraph()
        {
            for (int i = 0; i <num ; i++)
            {
                LinkedList<Edge> list = arr[i];
                for (int j = 0; j <list.size() ; j++)
                {
                    System.out.println("vertex-" + i + " is connected to " +
                            list.get(j).y + " with weight " +  list.get(j).z);
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.edgeAdd(0, 1, 4);
        graph.edgeAdd(0, 2, 3);
        graph.edgeAdd(1, 3, 2);
        graph.edgeAdd(1, 2, 5);
        graph.edgeAdd(2, 3, 7);
        graph.edgeAdd(3, 4, 2);
        graph.edgeAdd(4, 0, 4);
        graph.edgeAdd(4, 1, 4);
        graph.edgeAdd(4, 5, 6);
        graph.printGraph();
    }
}
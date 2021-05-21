package SortingAlgorithms;
import java.util.ArrayList;
class HashNode<M, N> {
    M main;
    N number;
    HashNode<M, N> next;
    public HashNode(M main, N number)
    {
        this.main = main;
        this.number = number;
    }
}
class Map<M, N> {
    private ArrayList<HashNode<M, N> > bskarr;
    private int buskets;
    private int width;
    public Map()
    {
        bskarr = new ArrayList<>();
        buskets = 10;
        width = 0;
        for (int i = 0; i < buskets; i++)
            bskarr.add(null);
    }
    public int width()
    {
        return width;
    }
    public boolean isEmpty()
    {
        return width() == 0;
    }
    private int getBucketIndex(M main)
    {
        int hashCode = main.hashCode();
        int temp = hashCode % buskets;
        temp = temp < 0 ? temp * -1 : temp;
        return temp;
    }
    public N remove(M main)
    {
        int bucketIndex = getBucketIndex(main);
        HashNode<M, N> top = bskarr.get(bucketIndex);
        HashNode<M, N> back = null;
        while (top != null) {
            if (top.main.equals(main))
                break;
            back = top;
            top = top.next;
        }
        if (top == null)
            return null;
        width--;
        if (back != null)
            back.next = top.next;
        else
            bskarr.set(bucketIndex, top.next);
        return top.number;
    }
    public N get(M main)
    {
        int bucketIndex = getBucketIndex(main);
        HashNode<M, N> head = bskarr.get(bucketIndex);
        while (head != null) {
            if (head.main.equals(main))
                return head.number;
            head = head.next;
        }
        return null;
    }
    public void add(M main, N number)
    {
        int bucketIndex = getBucketIndex(main);
        HashNode<M, N> head = bskarr.get(bucketIndex);
        while (head != null) {
            if (head.main.equals(main)) {
                head.number = number;
                return;
            }
            head = head.next;
        }
        width++;
        head = bskarr.get(bucketIndex);
        HashNode<M, N> newNode
                = new HashNode<M, N>(main, number);
        newNode.next = head;
        bskarr.set(bucketIndex, newNode);
        if ((1.0 * width) / buskets >= 0.7) {
            ArrayList<HashNode<M, N> > temp = bskarr;
            bskarr = new ArrayList<>();
            buskets = 2 * buskets;
            width = 0;
            for (int i = 0; i < buskets; i++)
                bskarr.add(null);

            for (HashNode<M, N> headNode : temp) {
                while (headNode != null) {
                    add(headNode.main, headNode.number);
                    headNode = headNode.next;
                }
            }
        }
    }
    public static void Main(String[] args)
    {
        Map<String, Integer> map = new Map<>();
        map.add("hello", 1);
        map.add("this", 2);
        map.add("is", 4);
        map.add("ads", 5);
        System.out.println(map.width());
        System.out.println(map.remove("this"));
        System.out.println(map.width());
        System.out.println(map.isEmpty());
    }
}
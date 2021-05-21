package SortingAlgorithms;
import java.util.*;
public class MyList<T extends Comparable <? super T>> {
    private boolean value;
    public MyList(boolean a_value) {
        value = a_value;
    }
    public static void main(String[] args) {
        MyList<Integer> ab = new MyList(false);
        List<Integer> x = new ArrayList<Integer>();
        x.add(4);
        x.add(3);
        x.add(7);
        x.add(0);
        x.add(1);
        x.add(2);
        x.add(9);
        System.out.println(x.toString());
        System.out.println("calling mergesort");
        List<Integer> result = ab.mergesort(x);
        System.out.println(result.toString());
        MyList<String> ab2 = new MyList(false);
        List<String> y = new ArrayList<String>();
        y.add("four");
        y.add("three");
        y.add("seven");
        y.add("zero");
        y.add("one");
        y.add("two");
        y.add("nine");
        System.out.println(y.toString());
        System.out.println("calling mergesort");
        List<String> result2 = ab2.mergesort(y);
        System.out.println(result2.toString());
    }
    public List<T> mergesort(List<T> list) {
        if(value)
            System.out.println("domergesort called on arg (" + list.toString() + ")");
        if(list.size() <= 1) {
            if(value)
                System.out.println("Returning single length list: " + list.toString());
            return list;
        } else {
            List<T> lft = new ArrayList<T>();
            List<T> rght = new ArrayList<T>();

            int mid = list.size() / 2;
            for(int i=0;i<mid;i++) {
                lft.add(list.get(i));
            }
            for(int i=mid;i<list.size();i++) {
                rght.add(list.get(i));
            }
            if(value)
                System.out.println("Calling merge on left: " + lft.toString() + " and right: " + rght.toString());
            return merge(mergesort(lft), mergesort(rght));
        }
    }
    private List<T> merge(List<T> a, List<T> b) {
        List<T> newl = new ArrayList<T>();
        int a_idx = 0, b_idx = 0;
        while(a_idx+1 <= a.size() || b_idx+1 <= b.size()) {
            if(a_idx+1 <= a.size() && b_idx+1 <= b.size()) {
                if(a.get(a_idx).compareTo(b.get(b_idx)) <= 0.0) {
                    newl.add(a.get(a_idx));
                    a_idx++;
                }
                else {
                    newl.add(b.get(b_idx));
                    b_idx++;
                }
            }
            else if(a_idx+1 <= a.size()) {
                newl.add(a.get(a_idx));
                a_idx++;
            }
            else if(b_idx+1 <= b.size()) {
                newl.add(b.get(b_idx));
                b_idx++;
            }
        }
        if(value)
            System.out.println("Returning merged array: " + newl.toString());
        return newl;
    }
}
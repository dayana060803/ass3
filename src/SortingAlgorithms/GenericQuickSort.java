package SortingAlgorithms;
import java.util.Arrays;
public class GenericQuickSort {
    public <T extends Comparable<T>> T[] quickSort(T[] arr) {
        Sort(arr, 0, arr.length - 1);
        return arr;
    }
    static <T> boolean swap(T[] arr, int x, int y){
        T swap = arr[x];
        arr[x] = arr[y];
        arr[y] = swap;
        return true;
    }
    static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    private static <T extends Comparable<T>> void Sort(T[] arr, int lft, int rght) {
        if (lft < rght) {
            int pvt = partition(arr, lft, rght);
            Sort(arr, lft, pvt - 1);
            Sort(arr, pvt , rght);
        }
    }
    private static <T extends Comparable<T>> int partition(T[] arr, int lft, int rght) {
        int mid = (lft + rght) / 2;
        T pvt = arr[mid];
        while(lft <= rght) {
            while(less(arr[lft], pvt)){
                ++lft;
            }
            while(less(pvt, arr[rght])) {
                --rght;
            }
            if(lft <= rght) {
                swap(arr, lft, rght);
                ++lft;
                --rght;
            }
        }
        return lft;
    }
    public static void main(String[] args) {
        Integer[] arr =  {-8, 0, 140, 5, 66, 10, 8, 55, 78, 63, -100, 25, 16, -65, 75};
        GenericQuickSort quickSort = new GenericQuickSort();
        System.out.println("Before sorting : " +Arrays.toString(arr));
        quickSort.quickSort(arr);
        System.out.println("After sorting : " + Arrays.toString(arr));
        String[] stringArray =  {"f", "a", "x", "k", "d"};
        System.out.println("Before sorting : " +Arrays.toString(stringArray));
        quickSort.quickSort(stringArray);
        System.out.println("After sorting : " + Arrays.toString(stringArray));
    }
}
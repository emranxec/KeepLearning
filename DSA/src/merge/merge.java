package merge;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class merge {

    public static void main(String[] args) {
            int a[] = {1, 3, 5, 7}, b[] = {2, 4, 6, 8};
            int size = a.length;
            int size1 = b.length;

            // Function call
            mergeArrays(a, b, size, size1);
            mergeArraysUsingStream(a, b, size, size1);
        }

    private static void mergeArraysUsingStream(int[] a, int[] b, int size, int size1) {
        IntStream stream0= Arrays.stream(a);
        IntStream stream1= Arrays.stream(b);

        IntStream intStream= IntStream.concat(stream0,stream1);
        intStream.sorted().forEach((s)-> System.out.print(" " + s));
    }


    static void mergeArrays(int a[], int b[], int n, int m) {

        // Declaring a map.
        // using map as a inbuilt tool
        // to store elements in sorted order.
        Set<Integer> mp = new TreeSet<>();

        // Inserting values to a map.
        for (int i = 0; i < n; i++) {
            mp.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            mp.add(b[i]);
        }

        // Printing keys of the map.
        for (Integer i:mp) {
            System.out.print(" " + i);
        }
        System.out.println("");

    }

}

    // Driver Code

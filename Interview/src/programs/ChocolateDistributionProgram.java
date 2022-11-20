package programs;

import java.util.Arrays;

public class ChocolateDistributionProgram {
    public static void main(String[] args) {
        //int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
          int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m =7 ;
        int minimumDifference = findDistribution(arr,m);
        System.out.println(minimumDifference);
    }

    private static int findDistribution(int[] arr, int m) {

        if (m == 0 || arr.length == 0)
            return 0;

        Arrays.sort(arr);

        if (arr.length < m)
            return -1;

        int minimum=0;
        // {2, 3, 4, 7, 9, 12, 56};
        for(int i=0;i<(arr.length-(m-1));i++){
            if(arr[i]<arr[i+(m-1)]){
                int newMinimum= (arr[i+(m-1)]-arr[i]);
                minimum= minimum==0?newMinimum:Math.min(newMinimum, minimum);
            }
        }
        return minimum;
    }
}

package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//not solved
public class FindCombinations {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Integer[] myArr={2,5,7,9,10,3,4, 6};
       // findCombinations(myArr,16);
        uniqueCombination(myArr,16);
    }

    private static void uniqueCombination(Integer[] myArr, int k) {
        System.out.println("-------uniqueCombination----------!");
        List<Integer> myList= Arrays.asList(myArr);
        List<Integer> local= new ArrayList<>();
        Collections.sort(myList);
        findUniqueCombination(0,0,k,local,myArr);
    }

    private static void findUniqueCombination(int l, int sum, int k, List<Integer> local, Integer[] myArr) {

        if(sum==k){
            System.out.print("{");
            for (int i = 0; i < local.size(); i++) {
                if (i != 0)
                    System.out.print(" ");
                System.out.print(local.get(i));
                if (i != local.size() - 1)
                    System.out.print(", ");
            }
            System.out.println("}");
        }

        for (int i = l; i < myArr.length; i++) {
            if (sum + myArr[i] > k)
                continue;

            if (i > l && myArr[i] == myArr[i-1] )
                continue;

            local.add(myArr[i]);
            findUniqueCombination(i+1,sum+myArr[i],k,local,myArr);
            local.remove(local.size() - 1);
        }
    }

    private static void findCombinations(Integer[] arr,int sum){

        for(int i=0;i<arr.length-2;i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] == sum) {
                        System.out.println(arr[i] + "," + arr[j]);
                    }
                    if (arr[i] + arr[k] == sum) {
                        System.out.println(arr[i] + "," + arr[k]);
                    }
                    if (arr[j] + arr[k] == sum) {
                        System.out.println(arr[j] + "," + arr[k]);
                    }
                    if (arr[i] + arr[j] + arr[k] == sum) {
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                    }
                }

            }
        }

    }
}

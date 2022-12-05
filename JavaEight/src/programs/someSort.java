package programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Map.Entry.comparingByValue;

public class someSort {

    public static void main(String[] args) {
        int[]  arr = {1, 2, 1, 3, 3, 1, 4, 5};
        //create an array of size 5
        //increment count;
        //print as per count
           /* int[] myInt=new int[arr.length];

            for(int i=0;i<= arr.length-1;i++){
                myInt[arr[i]]++;
            }*/
        //Arrays.sort(myInt);

        /*for(int i:myInt){
            System.out.println(i);
        }*/
        IntStream.of(arr).boxed().sorted().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .forEach(e-> {
                    int i=0;
                    while (i<e.getValue()){
                        System.out.println(e.getKey());
                        i++;
                    }
                });

       /* int[] newArray=new int[myArray.length];
        AtomicInteger i= new AtomicInteger();
        Arrays.stream(myArray).mapToInt(e->(int)e).forEach(e->newArray[i.getAndIncrement()]=e);
        System.out.println(newArray);*/



            /*for(int j=myInt.length-1;j>=0;j--){
                System.out.println(myInt[j]);
                for(int k=0;k<myInt.length;k++){
                    System.out.print(myInt[j]);
                }
            }*/
        //Output = {1, 1, 1, 3, 3, 2, 4, 5}

    }
}


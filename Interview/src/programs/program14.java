package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class program14 {

    public static void main(String[] args) {
        {
            int[] A = { 1, 2, 3, 4, 5 };
            List<Integer> oddNumbers = new ArrayList<>();
            IntStream.of(A).filter(e->e%2==1).mapToObj(e->oddNumbers.add(e*e)).count();

            System.out.println("Array is :  " + oddNumbers);
        }
    }
}

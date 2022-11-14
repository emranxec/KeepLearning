package programs;

import java.util.Arrays;
import java.util.Comparator;

public class findSecondHighestNumberProgram {
    public static void main(String[] args) {
        int[] myInt={2,3,4,1,5,6,7};

        findSecondHighestNumber(myInt);
        findSecondHighestNumber1(myInt);
    }
    private static void findSecondHighestNumber(int[] myInt) {
        System.out.println( Arrays.stream(myInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get());
    }
    private static void findSecondHighestNumber1(int[] myInt) {
        System.out.println( Arrays.stream(myInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findAny()
                .get());
    }
}

package programs.practice;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPrograms {
    public static void main(String[] args) {
        //prime numbers
        findPrimeBetweenRange(2, 16);
        findPrimeBetweenRangeUsingStream(2, 16);
        findFibonacciBetweenRange();
        findFibonacciBetweenRangeUsingStream();
        printFibbonacciUsingIterator(10);
    }

    private static void findFibonacciBetweenRange() {
        System.out.println("---findFibonacciBetweenRange---");
        int sum = 0;
        int first = 0;
        int second = 1;
        System.out.println(0);
        System.out.println(1);
        for (int i = 0; i < 8; i++) {
            sum = first + second;
            System.out.println(sum);
            first = second;
            second = sum;
        }

    }

    private static void printFibbonacciUsingIterator(int n) {
        int i = 0, a = -1, b = 1, c;
        System.out.println("-----printFibbonacciUsingIterator--");
        while (i < n) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
            i++;
        }

    }

    private static void findFibonacciBetweenRangeUsingStream() {
        System.out.println("---findFibonacciBetweenRangeUsingStream---");
        Stream
                .iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    private static void findPrimeBetweenRange(int i, int i1) {
        System.out.println("---findPrimeBetweenRange---");
        for (int j = i; j < i1; j++) {
            boolean isPrime = true;
            for (int k = 2; k <= Math.sqrt(i1); k++) {
                if (j != k && j % k == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(j);
            }
        }
    }

    private static void findPrimeBetweenRangeUsingStream(int i, int i1) {
        System.out.println("---findPrimeBetweenRangeUsingStream---");
        IntStream.range(i, i1).boxed().filter(InterviewPrograms::isPrime).forEach(System.out::println);
    }

    private static Boolean isPrime(Integer e) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(e)).noneMatch(d -> e % d == 0);
    }
}

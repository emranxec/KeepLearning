package com.xec.IntStream;

import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Programs {

    public static void main(String[] args) {
       //Apply 12% VAT on the purchase items and calculate the Bill
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
        removeFromCollection();


        int[] myInt={2,3,4,1,5,6,7};

        findSecondHighestNumber(myInt);
        findSecondHighestNumber1(myInt);

        StringJoiner stringJoiner=new StringJoiner(",");
        stringJoiner.add("imran");
        stringJoiner.add("khan");
        System.out.println(stringJoiner.toString());

        //How do you print ten random numbers using forEach?
        Random random = new Random();
        random
                .ints()
                .limit(10)
                .forEach(System.out::println);


        //How do you get the highest number that exists on a list?
        List<Integer> numbers = Arrays.asList(3, 12, 12, 3, 17, 3, 5);
        System.out.println("-------------find even----");
        numbers.stream().filter(a->a%2==0).forEach(System.out::println);
        System.out.println("-------------find even close----");

        System.out.println("-------------find out all the numbers starting with 1----");
        numbers.stream()
                .map(s-> s + "")
                .filter(s->s.startsWith("1"))
                .forEach(System.out::println);
        System.out.println("-------------find ends----");

        System.out.println("-------------find duplicate----");
        Set<Integer> mySet=new HashSet<>();
        numbers.stream()
                        .filter(n-> !mySet.add(n))
                            .distinct()
                                .forEach(System.out::println);

        System.out.println("-------------find duplicate ends----");

        System.out.println("-------------find first----");
        numbers.stream()
                .findFirst()
                        .ifPresent(System.out::println);

        System.out.println("-------------find first ends----");

        System.out.println("-------------total element----");
        System.out.println(numbers.stream()
                .count());
        System.out.println("-------------total element ends----");

        System.out.println("-------------find max----");
        System.out.println(numbers.stream()
                .max(Integer::compareTo).get());
        System.out.println("-------------find max ends----");

        System.out.println("-------------find first non repeated----");
        String input = "Java Hungry Blog Alive is Awesome";
        System.out.println(input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase((char) s)) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet().stream()
                        .filter(s->s.getValue()==1)
                .map(s->s.getKey())
                                .findFirst().get());

        System.out.println("-------------find first non repeated ends----");

        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);

        Date date=new Date();
        LocalDate firstInYear = LocalDate.of(date.getYear(),date.getMonth(), 1);

        LocalDate secondFriday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        System.out.println("Second friday :" + secondFriday);


    }
    static void removeFromCollection() {
        List<Integer> collect1 = Stream.of(10, 20, 30, 40).collect(Collectors.toList());
        collect1.removeIf(integer -> integer > 15);
        collect1.forEach(System.out::println);
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

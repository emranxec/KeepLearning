package programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntStreams {

    public static void main(String[] args) {
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

    }
}

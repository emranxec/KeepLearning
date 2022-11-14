package programs;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntStreams {

    public static void main(String[] args) {
        //How do you get the highest number that exists on a list?
        List<Integer> numbers = Arrays.asList(30, 17, 7, 3, 17, 3, 5);
        List<Integer> numbers2 = Arrays.asList(10, 27, 17, 13, 7, 13, 25);

        System.out.println("----join two list-----start");
        Stream<Integer> newStream = Stream.concat(numbers.stream(),numbers2.stream());
        newStream.forEach(System.out::println);
        System.out.println("----join two list-----ends");

        System.out.println("----Collectors partitioningBy() method in Java-----start");
        Map<Boolean, List<Integer>> booleanListMap = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        Map<Boolean, Long> booleanListMap1 = numbers.stream().collect(Collectors.partitioningBy(num -> (num % 2) == 0,Collectors.counting()));

        System.out.println(booleanListMap);
        System.out.println(booleanListMap1);
        System.out.println("----Collectors partitioningBy() method in Java-----ends");

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

        System.out.println("-------------find get non repeated ----");
        numbers.stream().collect(
                Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting()))
                        .entrySet()
                                .stream().filter(e->e.getValue()==1)
                        .forEach(e-> System.out.println(e.getKey()));

        System.out.println("------------- find get non repeated ends----");

        System.out.println("-------------find first----");
        numbers.stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("-------------find first ends----");

        System.out.println("-------------total element----");
        System.out.println((long) numbers.size());
        System.out.println("-------------total element ends----");

        System.out.println("-------------find max----");
        System.out.println(numbers.stream()
                .max(Integer::compareTo).get());
        System.out.println("-------------find max ends----");

        System.out.println("-------------find first non repeated----");
        String input = "Java Hungry Blog Alive is Awesome";
   input.chars().mapToObj(c->Character.toLowerCase((char) c))
                   .collect(
                           Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting()))
           .entrySet().stream()
           .filter(e->e.getValue()==1).map(e->e.getKey()).findFirst().get();

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

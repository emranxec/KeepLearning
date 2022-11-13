package programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class countNamesUsingStreams {
    public static void main(String[] args) {
        countTheNames();
    }
    private static void countTheNames() {
        List<String> myList= Arrays.asList("imran","salman","ayesha","salman","ayesha","ayesha");
        myList.stream()
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new,Collectors.counting()))
                .entrySet().stream()
                .forEach(System.out::println);
    }
}

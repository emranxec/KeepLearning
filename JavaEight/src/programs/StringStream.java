package programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StringStream {

    public static void main(String[] args) {
        List<String> keywords = Arrays.asList("Apple", "Ananas", "Mango", "Banana", "Beer", "Apple", "Mango",
                "Mango");
        Map<String, List<String>> result = keywords.stream().sorted()
                .collect(Collectors.groupingBy(it -> it));
        System.out.println(result);
        allMethod(keywords);
    }
    public static void allMethod(List<String> words) {
        Map<String, Long> frequency = words.stream().collect(groupingBy(Function.identity(), counting()));
        System.out.println("frequency = " + frequency);
        Map<String, Integer> frequency2 = words.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));
        System.out.println("frequency2 = " + frequency2);
        Map<String, Long> frequency3 = words.stream().collect(groupingBy(e -> e, counting()));
        System.out.println("frequency3 = " + frequency3);
        Map<String, Integer> frequency4 = words.parallelStream().
                collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
        System.out.println("frequency4 = " + frequency4);
        Map<String, Long> frequency5 = words.parallelStream().collect(
                Collectors.groupingByConcurrent(
                        Function.identity(), Collectors.<String>counting()));
        System.out.println("frequency5 = " + frequency5);
        Map<String, Long> frequency6 = words.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.<String>counting()));
        System.out.println("frequency6 = " + frequency6);
    }

}

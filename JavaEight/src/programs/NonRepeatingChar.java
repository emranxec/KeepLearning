package programs;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonRepeatingChar {
        public static void main(String[] args) {
            findFirstNonRepeatingLetter("zzzzzbbbccccddehhhhiii", System.out::println);
        }

    private static void findFirstNonRepeatingLetter(String s, Consumer<Character> callback) {
            s.chars()
                    .mapToObj(i -> (char) i)
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream()
                    .filter(entry -> entry.getValue() == 1L)
                    .map(Map.Entry::getKey)
                    .findFirst().map(c -> {
                        callback.accept(c);
                        return c;
                    });
        }


}

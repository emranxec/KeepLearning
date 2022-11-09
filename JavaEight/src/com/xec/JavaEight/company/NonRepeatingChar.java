package com.xec.JavaEight.company;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingChar {
        public static void main(String[] args) {
            findFirstNonRepeatingLetter("zzzzzbbbccccddehhhhiii", System.out::println);
            countTheNames();
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

    private static void countTheNames() {
        List<String> myList= Arrays.asList("imran","salman","ayesha","salman","ayesha","ayesha");
        myList.stream()
                .collect(Collectors.groupingBy(Function.identity(),HashMap::new,Collectors.counting()))
                .entrySet().stream()
                .forEach(System.out::println);
    }
}

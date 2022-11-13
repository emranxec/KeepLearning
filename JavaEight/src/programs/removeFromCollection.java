package programs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class removeFromCollection {
    public static void main(String[] args) {
        removeFromCollection();
    }
    static void removeFromCollection() {
        List<Integer> collect1 = Stream.of(10, 20, 30, 40).collect(Collectors.toList());
        collect1.removeIf(integer -> integer > 15);
        collect1.forEach(System.out::println);
    }
}

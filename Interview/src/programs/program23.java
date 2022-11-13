package programs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class program23 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = (ss) -> ss.startsWith("G");

        // Iterate through the list
        for (String st : names) {
            // call the test method
            if (p.test(st))
                System.out.println(st);
        }
    }
}

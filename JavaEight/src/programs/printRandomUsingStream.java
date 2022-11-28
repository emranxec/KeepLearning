package programs;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class printRandomUsingStream {
    public static void main(String[] args) {
        //How do you print ten random numbers using forEach?
        Random random = new Random();
        random
                .ints()
                .limit(10)
                .forEach(System.out::println);
        System.out.println("---doubles----");
        random.doubles().boxed().limit(10).forEach(System.out::println);

        System.out.println("---without using random class----");
        System.out.println(IntStream.range(1,2).mapToLong(e->e* printRandomUsingStream.generate()).boxed().findAny().get());

        //without Stream
        printRandomUsingStream test = new printRandomUsingStream();
        long generate = test.generate();
    }

    public static long generate(){
        return System.currentTimeMillis() % 16;
    }
}

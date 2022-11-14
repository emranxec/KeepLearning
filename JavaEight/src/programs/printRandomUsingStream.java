package programs;

import java.util.Random;

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

    }
}

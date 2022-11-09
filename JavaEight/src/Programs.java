import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class A{
    void helloWorld() throws FileNotFoundException {}
}

class B extends A{
    @Override
    void helloWorld() throws RuntimeException{}
}
public class Programs {

    public static void main(String[] args) {
       //Apply 12% VAT on the purchase items and calculate the Bill
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
        removeFromCollection();
    }

    static void removeFromCollection() {
        List<Integer> collect1 = Stream.of(10, 20, 30, 40).collect(Collectors.toList());
        collect1.removeIf(integer -> integer > 15);
        collect1.forEach(System.out::println);
    }
}

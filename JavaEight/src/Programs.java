import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;


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
    }
}

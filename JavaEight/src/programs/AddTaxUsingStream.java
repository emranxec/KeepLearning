package programs;

import java.util.Arrays;
import java.util.List;

public class AddTaxUsingStream {
    public static void main(String[] args) {
        //Apply 12% VAT on the purchase items and calculate the Bill
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + 0.12*cost).reduce(Double::sum).get();
        System.out.println("Total : " + bill);
    }

}

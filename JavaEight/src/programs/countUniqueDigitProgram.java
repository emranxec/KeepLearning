package programs;

import java.util.HashSet;
import java.util.Set;

public class countUniqueDigitProgram {
    public static void main(String[] args) {
        int a = 12333445;
        System.out.println(countUniqueDigit(a));
    }
    private static int countUniqueDigit(int num) {
        Set<Integer> digits = new HashSet<>();

        while(num>0){
            digits.add(num%10);
            num/=10;
        }
        return digits.size();

        /*     // iterate to each digit
            while (num > 0) {
                // find last digit
                // add it to collection
                digits.add(num % 10);
                // remove last digit
                num /= 10;
            }

            // return size
            return digits.size();*/
    }
}

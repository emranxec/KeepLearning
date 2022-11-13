package programs;

import java.util.HashSet;
import java.util.Set;

public class program17 {

    public static void main(String[] args) {
        int num=1110003;
        countNumberOfUniqueNumbers(num);
    }

    private static void countNumberOfUniqueNumbers(int num) {
        //	Write a function to count the number of unique digits in a number

        Set<Integer> digits=new HashSet<>();
        while(num>0){
            digits.add(num%10);
            num=num/10;
        }
        System.out.println(digits.size());
    }
}

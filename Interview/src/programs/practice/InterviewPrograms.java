package programs.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPrograms {
    public static void main(String[] args) {
        //prime numbers
        findPrimeBetweenRange(2, 16);
        findPrimeBetweenRangeUsingStream(2, 16);
        findFibonacciBetweenRange();
        findFibonacciBetweenRangeUsingStream();
        printFibbonacciUsingIterator(10);

        String str = "aga";

        // Convert the string to lowercase
        str = str.toLowerCase();
        boolean A = isPalindrome(str);
        System.out.println(str + "is a Palindrome: "+ A);
        boolean B = isPalindrome(str);
        System.out.println(str + "is a Palindrome: "+ B);

        char str1[] = { 'a', 'r', 'm' };
        char str2[] = { 'a', 'r', 'm' };

        // Function Call
        if (areAnagram(str1, str2))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");

        if (areAnagramUsingCountArray(str1, str2))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");

        if (isAnagram("aga", "aga"))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }

    private static boolean areAnagram(char[] str1, char[] str2) {
        System.out.println("----------areAnagram---------------");
        int n1= str1.length;
        int n2= str2.length;

        if(n1!=n2)
            return false;
        Arrays.sort(str1);
        Arrays.sort(str2);

        for(int i=0;i<n1;i++){
            if(str1[i]!=str2[i]){
                return false;
            }
        }
        return true;
    }

    static int NO_OF_CHAR=256;
    private static boolean areAnagramUsingCountArray(char[] str1, char[] str2) {
        System.out.println("----------areAnagramUsingCountArray---------------");
        int[] count =new int[NO_OF_CHAR];
        if (str1.length != str2.length)
            return false;

        for(int i=0;i<str1.length;i++){
           count[str1[i]]++;
           count[str2[i]]--;
        }

        for(int i=0;i<NO_OF_CHAR;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String a, String b)
    {
        System.out.println("----------isAnagram using hashmap ---------------");
        // Check if length of both strings is same or not
        if (a.length() != b.length()) {
            return false;
        }
        // Create a HashMap containing Character as Key and
        // Integer as Value. We will be storing character as
        // Key and count of character as Value.
        HashMap<Character, Integer> map = new HashMap<>();
        // Loop over all character of String a and put in
        // HashMap.
        for (int i = 0; i < a.length(); i++) {
            // Check if HashMap already contain current
            // character or not
            if (map.containsKey(a.charAt(i))) {
                // If contains increase count by 1 for that
                // character
                map.put(a.charAt(i),
                        map.get(a.charAt(i)) + 1);
            }
            else {
                // else put that character in map and set
                // count to 1 as character is encountered
                // first time
                map.put(a.charAt(i), 1);
            }
        }
        // Now loop over String b
        for (int i = 0; i < b.length(); i++) {
            // Check if current character already exists in
            // HashMap/map
            if (map.containsKey(b.charAt(i))) {
                // If contains reduce count of that
                // character by 1 to indicate that current
                // character has been already counted as
                // idea here is to check if in last count of
                // all characters in last is zero which
                // means all characters in String a are
                // present in String b.
                map.put(b.charAt(i),
                        map.get(b.charAt(i)) - 1);
            }
            else {
                return false;
            }
        }
        // Extract all keys of HashMap/map
        Set<Character> keys = map.keySet();
        // Loop over all keys and check if all keys are 0.
        // If so it means it is anagram.
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        // Returning True as all keys are zero
        return true;
    }



    private static boolean isPalindrome(String str) {
        System.out.println("----------isPalindrome---------------");

        int i=0,j=str.length()-1;

        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String A)
    {
        System.out.println("---isPalindromeRecursive---");
        return isPalindrome(0, A.length() - 1, A);
    }

    private static boolean isPalindrome(int i, int i1, String a) {
       if(a.charAt(i)!=a.charAt(i1)){
           return false;
       }
       return isPalindrome(i+1,i1-1,a);
    }



    private static void findFibonacciBetweenRange() {
        System.out.println("---findFibonacciBetweenRange---");
        int sum = 0;
        int first = 0;
        int second = 1;
        System.out.println(0);
        System.out.println(1);
        for (int i = 0; i < 8; i++) {
            sum = first + second;
            System.out.println(sum);
            first = second;
            second = sum;
        }

    }

    private static void printFibbonacciUsingIterator(int n) {
        int i = 0, a = -1, b = 1, c;
        System.out.println("-----printFibbonacciUsingIterator--");
        while (i < n) {
            c = a + b;
            System.out.println(c + " ");
            a = b;
            b = c;
            i++;
        }

    }

    private static void findFibonacciBetweenRangeUsingStream() {
        System.out.println("---findFibonacciBetweenRangeUsingStream---");
        Stream
                .iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    private static void findPrimeBetweenRange(int i, int i1) {
        System.out.println("---findPrimeBetweenRange---");
        for (int j = i; j < i1; j++) {
            boolean isPrime = true;
            for (int k = 2; k <= Math.sqrt(i1); k++) {
                if (j != k && j % k == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(j);
            }
        }
    }

    private static void findPrimeBetweenRangeUsingStream(int i, int i1) {
        System.out.println("---findPrimeBetweenRangeUsingStream---");
        IntStream.range(i, i1).boxed().filter(InterviewPrograms::isPrime).forEach(System.out::println);
    }

    private static Boolean isPrime(Integer e) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(e)).noneMatch(d -> e % d == 0);
    }
}

package programs;

import java.util.Comparator;
import java.util.stream.Stream;

public class program16 {

    public static void main(String[] args) {
        String sentence = "my name amanulla is, imran khan-";
        System.out.println( findLongest(sentence));
        System.out.println( findLongestUsingJavaStream(sentence));
    }

    private static String findLongestUsingJavaStream(String sentence) {
        return Stream.
                of(sentence.split("[^a-zA-Z0-9]"))
                .filter(sub->sub.length()%2==0)
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    public static String findLongest(String sentence){

        // String[] subs=String.replaceAll(rejex(/a-z/A-Z),sentense).split(sentence," ");
        String[] subs=sentence.split("[^a-zA-Z0-9]");



        String longest="";
        for(String sub:subs){
            if(sub.length()%2==0 && sub.length()>longest.length()){
                longest=sub;
            }
        }
        return 	longest;

    }
}

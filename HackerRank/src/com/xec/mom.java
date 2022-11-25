package com.xec;

import java.util.*;
import java.util.stream.Stream;

public class mom {

    // you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    public static String solution(int N, int K) {
        // write your code in Java SE 8
        //kayak, radar,mom
        //5,2 //abbba
        //abbba
        //8,3
        //abccccba
        //3,2
        //aba

        char[] myChars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] newChars = new char[N];
        int i = 0;
        int last = newChars.length - 1;
        for (char c : myChars) { //a
            if (K > 1) {
                newChars[i] = c;
                newChars[last] = c;
                K--;
                last--;
                i++;
            } else if (K == 1) {
                while (i <= last) {
                    newChars[i] = c;
                    i++;
                }
                K--;
            } else {
                break;
            }
        }
       // System.out.println(String.valueOf(newChars));
        return String.valueOf(newChars);


    }

    public static String solutionInJava8(int N, int K) {
        // write your code in Java SE 8
        //kayak, radar,mom
        //5,2 //abbba
        //abbba
        //8,3
        //abccccba
        //3,2
        //aba

        String myChars = "abcdefghijklmnopqrstuvwxyz".substring(0,K);
        //a,b
        String reverse= new StringBuilder(myChars).reverse().toString();
        char lastChar=reverse.charAt(0);
        return "No solutions found";

    }

    public static void main(String[] args) {
        System.out.println(solution(5,2));
    }
}



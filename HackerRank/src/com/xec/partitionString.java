package com.xec;

import java.util.HashSet;

public class partitionString {

    public static void main(String[] args) {
        String partSubstring="abacaba";
        System.out.println(partSubstring);
        System.out.println(partitionString(partSubstring));
        System.out.println(partitionStringUsingHashSet(partSubstring));
    }



    public static int partitionString(String s) {
        //abacaba
        //ab ac ab a
        //ab,ac,ab,a
        //ab ac a ba
        int n=s.length();
        int sub=0;
        String[] subs= new String[n];
        for(int i=0;i<n;i++){
            if(i>0 && !subs[sub-1].contains(String.valueOf(s.charAt(i)))){
                subs[sub-1]=subs[sub-1]+s.charAt(i);
            }else {
                subs[sub] = String.valueOf(s.charAt(i));
                sub++;
            }
        }
        return sub;
    }

    private static int partitionStringUsingHashSet(String s) {
        int n=s.length();
        int sub=0;
        HashSet<Character> subs= new HashSet<>();
        for(int i=0;i<n;i++){
            if(!subs.contains(s.charAt(i))){
                subs.add(s.charAt(i));
            }else {
                sub++;
                subs.clear();
                subs.add(s.charAt(i));
            }
        }
        return ++sub;
    }
}

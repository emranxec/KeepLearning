package com.xec.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRemoveSpace {
    public static void main(String[] args) {
        String s= "i am        a senior software Engi ne      e";
        String constants = "";
        String result = s.replaceAll("\\s", "");
        System.out.println("using replace all------------- "+ result);
        Pattern p= Pattern.compile("[a-zA-Z]");
        Matcher m=p.matcher(s);
        StringBuilder stringBuilder=new StringBuilder();
        while (m.find()){
            constants=constants+m.group();
            m.appendReplacement(stringBuilder,"");
        }
        m.appendTail(stringBuilder);
        System.out.println("using Pattern------------" + constants);


        StringBuilder sb=new StringBuilder();
        s.chars().mapToObj(e->(char) e).filter(e->!e.equals(' ')).forEach(sb::append);
        System.out.println("using streams------" + sb);


        String str[] = s.split(" ");
        String result1 = "";
        for(int i=0; i<str.length; i++) {
            result1 = result1+str[i];
        }
        System.out.println("using split------"+result1);
    }
}

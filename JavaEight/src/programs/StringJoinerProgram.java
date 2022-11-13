package programs;

import java.util.StringJoiner;

public class StringJoinerProgram {
    public static void main(String[] args) {
        StringJoiner stringJoiner=new StringJoiner(",");
        stringJoiner.add("imran");
        stringJoiner.add("khan");
        System.out.println(stringJoiner.toString());
    }

}

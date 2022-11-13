package programs;

import java.util.HashSet;
import java.util.Set;

public class program18 {
    static Set<String> permute=new HashSet<>();
    public static void main(String[] args) {
        String str = "okk";
        int n = str.length();
        Set permute=permute(str, 0, n-1);
        System.out.println(permute);
    }

    private static Set permute(String str, int l, int r)
    {

        if (l == r){
            permute.add(str);}
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
        return permute;
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}


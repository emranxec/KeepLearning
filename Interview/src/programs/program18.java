package programs;

import java.util.HashSet;
import java.util.Set;

public class program18 {
    static Set<String> permute = new HashSet<>();

    public static void main(String[] args) {
        String str = "abc";
        int n = str.length();
        Set permute = permute(str, 0, n - 1);
        System.out.println(permute);
    }

    private static Set permute(String str, int l, int r) {
        if(l==r){
            permute.add(str);
        }
        else{
            for(int i=l;i<=r;i++){
                str= swap(str,l,i);
                permute(str,l+1,r);
                str= swap(str,l,i);
            }
        }
        return permute;
    }

    private static String swap(String str, int l, int i) {
        char temp;
        char[] mychars=str.toCharArray();
        temp=mychars[l];
        mychars[l]=mychars[i];
        mychars[i]=temp;
        return String.valueOf(mychars);
    }


}

package programs;

import java.util.Arrays;

public class program15 {

    public static void main(String[] args) {
       // int[] pairs={7,8,9,1,2,3,4,5,6,}; //k=4
        int[] pairs={1,2,3,4,5}; //k=4
        int k=2;
        pairs(pairs,k);
    }

    private static void pairs(int[] pairs,int k) {

        //{1,2,3,4,5,6,7,8,9}
        int count = 0;
        Arrays.sort(pairs); // Sort array elements

        int l = 0;
        int r = 0;
        while(r < pairs.length){
            if(pairs[r]-pairs[l]==k){
                count++;
                l++;
                r++;
            }else if(pairs[r]-pairs[l]>k){
                l++;
            }else {
                r++;
            }

        }
        System.out.println(count);
    }
}

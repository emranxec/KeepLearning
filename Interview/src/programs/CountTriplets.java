package programs;

import java.util.Arrays;

public class CountTriplets {
    static int[] arr = new int[]{5, 1, 3, 4, 7};

    public static void main(String[] args) {
        int sum = 12;
        System.out.println(countTriplets(arr.length, sum));
    }

    private static int countTriplets(int n, int sum) {
        int ans=0;
        Arrays.sort(arr); //1,3,4,5,7
        for(int i=0;i<=n-2;i++){

            int j=i+1,k=n-1;

            while (j<k){
                if(arr[i]+arr[j]+arr[k]>=sum)
                    k--;
                else
                {
                    ans+=(k-j);
                    j++;
                }
            }
        }

        return ans;
    }
}

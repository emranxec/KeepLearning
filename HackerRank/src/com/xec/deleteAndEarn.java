package com.xec;

import java.util.Arrays;
import java.util.List;

public class deleteAndEarn {

    public static void main(String[] args) {
        int[] numbers={3,4,2,5};
        System.out.println(deleteAndEarn(numbers));
    }

    public static int deleteAndEarn(int[] nums) {
        //[3,4,2,5]
        int[] values=new int[10001];
        for(int num:nums){
            values[num]+=num;
        }
        int take=0,skip=0;
        for(int i=0;i<10001;i++){
            int takei= skip+values[i];
            int skipi=Math.max(skip,take);
            take=takei;
            skip=skipi;

        }
      return Math.max(take,skip);
    }
}

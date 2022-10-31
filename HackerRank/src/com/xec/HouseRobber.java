package com.xec;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        int[] robHouse={2,1,1,2};
        System.out.println(rob(robHouse));
    }


    public static int rob(int[] nums) {
        //[2,1,1,2 ]
        // PR[2][1][3][4]
        // NP[0][2][2][3]

        int ifRobbedPrevious =0;
        int ifDidntRobPrevious =0;
        for(int i=0;i<nums.length;i++){
            int currRobbed = ifDidntRobPrevious + nums[i];
            int currNotRobbed = Math.max(ifDidntRobPrevious,ifRobbedPrevious);

            ifRobbedPrevious=currRobbed;
            ifDidntRobPrevious=currNotRobbed;

        }

        return Math.max(ifDidntRobPrevious,ifRobbedPrevious);
    }

}

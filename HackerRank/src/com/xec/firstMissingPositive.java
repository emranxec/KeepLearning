package com.xec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class firstMissingPositive {

    public static void main(String[] args) {
        int[] numbers={3,4,-1,2,5,6,7,1};
        System.out.println(firstMissingPositive(numbers));
    }

    public static int firstMissingPositive(int[] nums) {

        for(int i=0;i<nums.length;i++){
          while(nums[i]>0 && nums[i]<nums.length && nums[nums[i]-1]!=nums[i]){
              swap(nums,i,nums[i]-1);
          }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}

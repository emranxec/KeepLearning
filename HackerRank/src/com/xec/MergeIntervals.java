package com.xec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] myArray={{1,4},{0,2},{3,5},{15,18}};
        //[[1,4],[0,2],[3,5]]
        //int[][] myArray={{1,4},{0,0},{8,10},{15,18}};
        //int[][] myArray={{0,0},{1,4},{8,10},{15,18}};

        //int[][] myArray={{2,3},{4,5},{6,7},{1,10},{8,9}};

        int[][] mergeInterval = merge(myArray);
        for(int[] myInt:mergeInterval){
            for(int i:myInt){
                System.out.print(i);
            }
            System.out.println(" ");
        }
    }

    public static int[][] merge(int[][] intervals) {
        java.util.Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        //[[1,3],[2,6],[8,10],[15,18]]
        //[1,6]
        //[[1,3]]
        int min=0,max=0;
        int mergePointer=0;
        int OriginalPointer=0;
        for(int[] subs: intervals){
            if(OriginalPointer==0) {
                min = subs[0];
                max = subs[1];
                OriginalPointer++;
                continue;
            }
            if(max>=subs[0]){
                if(min>subs[0] && subs[0]==subs[1]){
                    intervals[mergePointer][mergePointer]=subs[0];
                    intervals[mergePointer][1]=subs[1];
                    mergePointer++;
                }else{
                    min= Math.min(min, subs[0]);
                    max= Math.max(max, subs[1]);
                }
                intervals[mergePointer][0]=min;
                intervals[mergePointer][1]=max;
                OriginalPointer++;
            }
            else{
                mergePointer++;
                min= intervals[OriginalPointer][0];
                max= intervals[OriginalPointer][1];
                intervals[mergePointer][0]=min;
                intervals[mergePointer][1]=max;
                OriginalPointer++;
            }

        }
        return Arrays.copyOfRange(intervals, 0, mergePointer + 1);
    }
}

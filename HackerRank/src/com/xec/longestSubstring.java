package com.xec;

public class longestSubstring {

    public static void main(String[] args) {
        String longestSubstring="ababcabaaadc";
        System.out.println(longestSubstring(longestSubstring,2));
    }

    public static int longestSubstring(String s, int k) {
        //ababbc
        return  longestSubstringUtil(s, 0, s.length(), k);
    }

    private static int longestSubstringUtil(String s, int start, int end, int k) {
        if(end<k){
            return 0;
        }
        int[] countMap = new int[26];

        for(int i=start;i<end;i++){
            countMap[s.charAt(i)-'a']++;
        }
        for(int mid=start;mid<end;mid++){
            if(countMap[s.charAt(mid)-'a']>=k){
                continue;
            }
            int midNext=mid+1;

            while(midNext<end && countMap[s.charAt(midNext)-'a']<k) {
                midNext++;
            }
                return Math.max(longestSubstringUtil(s,start,mid,k),
                        longestSubstringUtil(s,midNext,end,k));
            }
        return (end-start);
        }
    }


/*
 * Problem: 739. Daily Temperatures
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/daily-temperatures/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
     public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int[] arr=new int[temperatures.length];
        int idx=0;
        for (int i = 0; i < temperatures.length; i++) {
            while (idx>0&&temperatures[i]>temperatures[arr[idx-1]]) {
                res[arr[idx-1]]=i-arr[idx-1];
                idx--;
            }
            arr[idx++]=i;
        }
        return res;
    }
}

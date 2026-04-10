/*
 * Problem: 907. Sum of Subarray Minimums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-subarray-minimums/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] sum=new int[arr.length];
        int[] less=new int[arr.length];
        int res=0;
        for (int i=0;i<arr.length;i++) {
            int l=i-1;
            while (l>=0&&arr[i]<arr[l]) {
                l=less[l];
            }
            if (l==-1) {
                sum[i]=((i-l)*arr[i]);
            } else {
                sum[i]=(sum[l]+(i-l)*arr[i]);
            }
            res=(res+sum[i])%1000000007;
            less[i]=l;
        }
        return res;
    }
}

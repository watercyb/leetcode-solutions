/*
 * Problem: 2897. Apply Operations on Array to Maximize Sum of Squares
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod=1_000_000_007;
        int max=0;
        for (int num:nums) {
            max=Math.max(max,num);
        }
        int len=32-Integer.numberOfLeadingZeros(max);
        int[] counts=new int[len];
        for (int num:nums) {
            for (int i=0;num>0;i++) {
                    counts[i]+=num&1;
                num>>=1;
            }
        }
        int[] arr=new int[k];
        for (int i=0;i<len;i++) {
            int base=1<<i;
            for (int j=0;j<Math.min(counts[i],k);j++) {
                arr[j]+=base;
            }
        }
        long res=0;
        for (int i=0;i<k&&arr[i]!=0;i++) {
           res=(res+(long)arr[i]*arr[i] )%mod;
        }
        return (int)res;
    }
}

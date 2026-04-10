/*
 * Problem: 974. Subarray Sums Divisible by K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] counts=new int[k];
        counts[0]=1;
        int res=0;
        int sum=0;
        for (int num:nums) {
            sum+=num;
            int tmp=sum%k;
            if (tmp<0) tmp+=k;
            res+=counts[tmp]++;
        }
        return res;
    }
}

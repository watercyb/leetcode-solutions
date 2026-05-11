/*
 * Problem: 3862. Find the Smallest Balanced Index
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-smallest-balanced-index/
 * Language: csharp
 * Date: 2026-05-11
 */

public class Solution {
    public int SmallestBalancedIndex(int[] nums) {
        long[] lefts=new long[nums.Length];
        long sum=0;
        for (int i=0;i<nums.Length;i++) {
            lefts[i]=sum;
            sum+=nums[i];
        }
        int res=-1;
        long pro=1;
        for (int i=nums.Length-1;i>=0&&pro<=sum&&pro>=0;i--) {
            if (pro==lefts[i]) res=i;
            pro*=nums[i];
        }
        return res;
    }
}

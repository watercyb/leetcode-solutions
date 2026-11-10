/*
 * Problem: 4110. Find the Maximum Length of Valid Subsequence III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-iii/
 * Language: csharp
 * Date: 2026-11-10
 */

public class Solution {
    public int MaximumLength(int[] nums, int k) {
        int[] dp=new int[k];
        int res=1;
        for (int i=0;i<nums.Length;i++) {
            int num=nums[i]%k;
            int target=(k-num)%k;
            dp[num]=dp[target]+1;
            res=Math.Max(res, dp[num]);
        }
        return res;
    }
}

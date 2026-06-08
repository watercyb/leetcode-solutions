/*
 * Problem: 3952. Maximum Total Value of Covered Indices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-value-of-covered-indices/
 * Language: csharp
 * Date: 2026-06-08
 */

public class Solution {
    public long MaxTotal(int[] nums, string s) {
        long a=0;
        long b=0;
        for (int i=0;i<nums.Length;i++) {
            int num=nums[i];
            char chr=s[i];
            if (chr=='1') {
                long temp=a;
                a=Math.Max(a+num,b);
                b=Math.Max(temp,b)+num;
            } else {
                b=a+num;
            }
        }
        return a;
    }
}

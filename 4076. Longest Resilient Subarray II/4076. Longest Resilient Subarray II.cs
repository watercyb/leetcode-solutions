/*
 * Problem: 4076. Longest Resilient Subarray II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-resilient-subarray-ii/
 * Language: csharp
 * Date: 2026-10-12
 */

public class Solution {
    public int ResilientSubarray(int[] nums, int k) {
        int prv=-1;
        int len=0;
        int res=0;
        int sum=0;
        foreach (int num in nums) {
            int n=num%k;
            if (n!=prv) {
                len=1;
                prv=n;
                sum=n;
            } else {
                len++;
                sum=(sum+n)%k;
            }
            if (sum==n&&len>res) res=len;
        }
        return res;
    }
}

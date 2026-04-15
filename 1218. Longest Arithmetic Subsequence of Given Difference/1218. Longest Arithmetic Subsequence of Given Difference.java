/*
 * Problem: 1218. Longest Arithmetic Subsequence of Given Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int in : arr) {
            max = Math.max(in, max);
            min = Math.min(in, min);
        }
        if (difference > 0) {
            min -= difference;
        } else {
            max -= difference;
        }
        int[] DP = new int[max - min + 1];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i] - difference - min;
            DP[arr[i]- min] = DP[tmp] + 1;
            res = Math.max(DP[arr[i]- min], res);
        }
        return res;
    }
}

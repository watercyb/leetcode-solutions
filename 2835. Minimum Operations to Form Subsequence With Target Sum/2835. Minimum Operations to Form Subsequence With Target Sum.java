/*
 * Problem: 2835. Minimum Operations to Form Subsequence With Target Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int[] counts = new int[32];
        for (int num : nums) {
            int n = 0;
            while (num > 1) {
                num /= 2;
                n++;
            }
            counts[n]++;
        }
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            if ((target & (1 << i)) != 0) {
                if (counts[i] > 0) {
                    counts[i]--;
                } else {
                    int j = i + 1;
                    while (j <= 30 && counts[j] == 0) {
                        j++;
                    }
                    if (j > 30)
                        return -1;
                    counts[j]--;
                    while (j > i) {
                        counts[j - 1] = 1;
                        j--;
                        res++;
                    }
                }
            }
            counts[i + 1] += counts[i] / 2;
        }
        return res;
    }
}

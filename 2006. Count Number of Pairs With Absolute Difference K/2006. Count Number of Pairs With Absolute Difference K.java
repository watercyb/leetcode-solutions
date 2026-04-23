/*
 * Problem: 2006. Count Number of Pairs With Absolute Difference K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] counts = new int[200];
        int res = 0;
        for (int num : nums) {
            counts[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            res += counts[i] * counts[i + k];
        }
        return res;
    }
}

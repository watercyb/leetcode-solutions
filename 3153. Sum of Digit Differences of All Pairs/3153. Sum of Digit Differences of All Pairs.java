/*
 * Problem: 3153. Sum of Digit Differences of All Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-digit-differences-of-all-pairs/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        long total = (long) nums.length * (nums.length - 1) / 2;
        while (nums[0] != 0) {
            int[] counts = new int[10];
            for (int i = 0; i < nums.length; i++) {
                counts[nums[i] % 10]++;
                nums[i] /= 10;
            }
            res += total;
            for (int i = 0; i < counts.length; i++) {
                res -= (long) counts[i] * (counts[i] - 1) / 2;
            }
        }
        return res;
    }
}

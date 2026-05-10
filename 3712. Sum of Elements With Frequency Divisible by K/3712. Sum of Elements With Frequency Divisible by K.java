/*
 * Problem: 3712. Sum of Elements With Frequency Divisible by K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-elements-with-frequency-divisible-by-k/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        int res = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] % k == 0)
                res += i * counts[i];
        }
        return res;
    }
}

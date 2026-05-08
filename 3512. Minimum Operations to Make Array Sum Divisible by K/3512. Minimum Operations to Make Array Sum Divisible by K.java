/*
 * Problem: 3512. Minimum Operations to Make Array Sum Divisible by K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}

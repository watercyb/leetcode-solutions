/*
 * Problem: 3432. Count Partitions with Even Sum Difference
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-partitions-with-even-sum-difference/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return 0;
        return nums.length - 1;
    }
}

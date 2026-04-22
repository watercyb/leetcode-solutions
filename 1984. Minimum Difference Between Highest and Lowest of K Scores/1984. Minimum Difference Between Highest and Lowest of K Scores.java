/*
 * Problem: 1984. Minimum Difference Between Highest and Lowest of K Scores
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            res = Math.min(nums[i + k - 1] - nums[i], res);
        }
        return res;
    }
}

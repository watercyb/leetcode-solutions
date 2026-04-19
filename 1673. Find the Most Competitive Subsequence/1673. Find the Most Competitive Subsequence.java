/*
 * Problem: 1673. Find the Most Competitive Subsequence
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-most-competitive-subsequence/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (idx > 0 && idx > k - nums.length + i && res[idx - 1] > nums[i]) {
                idx--;
            }
            if (idx < k)
                res[idx++] = nums[i];
        }
        return res;
    }
}

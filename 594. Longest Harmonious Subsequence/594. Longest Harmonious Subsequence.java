/*
 * Problem: 594. Longest Harmonious Subsequence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-harmonious-subsequence/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            int count = 1;
            while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                count++;
                i++;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i] + 1) {
                count++;
                j++;
            }
            if (j > i + 1 && count > res)
                res = count;
            i++;
        }
        return res;
    }
}

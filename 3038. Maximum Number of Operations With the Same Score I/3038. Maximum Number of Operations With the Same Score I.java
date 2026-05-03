/*
 * Problem: 3038. Maximum Number of Operations With the Same Score I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxOperations(int[] nums) {
        int target = nums[0] + nums[1];
        int res = 1;
        for (int i = 2; i < nums.length-1; i += 2) {
            if (nums[i] + nums[i + 1] != target)
                break;
            res++;
        }
        return res;
    }
}

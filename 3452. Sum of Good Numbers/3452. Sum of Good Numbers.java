/*
 * Problem: 3452. Sum of Good Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-good-numbers/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = i - k;
            int r = i + k;
            if (l >= 0 && nums[l] >= nums[i])
                continue;
            if (r < nums.length && nums[r] >= nums[i])
                continue;
            res+=nums[i];
        }
        return res;
    }
}

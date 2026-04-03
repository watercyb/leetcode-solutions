/*
 * Problem: 487. Max Consecutive Ones II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-consecutive-ones-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int r = 0;
        int count = 0;
        while (r < nums.length) {
            if (nums[r] == 0)
                count++;
            if (count > 1) {
                count -= 1 - nums[l];
                l++;
            }
            r++;
        }
        return r-l;
    }
}

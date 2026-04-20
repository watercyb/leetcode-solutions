/*
 * Problem: 1793. Maximum Score of a Good Subarray
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-of-a-good-subarray/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maximumScore(int[] nums, int k) {
        int l = k;
        int r = k;
        int min = nums[k];
        int max = 0;
        while (l >= 0 || r < nums.length) {
            while (l >= 0 && nums[l] >= min)
                l--;
            while (r < nums.length && nums[r] >= min)
                r++;
            max = Math.max((r - l - 1) * min, max);
            if (l >= 0 && r < nums.length) {
                if (nums[l] >= nums[r]) {
                    min = nums[l];
                    l--;
                } else {
                    min = nums[r];
                    r++;
                }
            } else if (l >= 0) {
                min = nums[l];
                l--;
            } else if (r < nums.length) {
                min = nums[r];
                r++;
            }
            if (nums.length * min <= max)
                return max;
        }
        max = Math.max(nums.length * min, max);
        return max;
    }
}

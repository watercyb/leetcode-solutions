/*
 * Problem: 3034. Number of Subarrays That Match a Pattern I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int res = 0;
        for (int i = 0; i < nums.length - pattern.length; i++) {
            res += chk(nums, pattern, i);
        }
        return res;
    }

    public int chk(int[] nums, int[] pattern, int i) {
        for (int j = 0; j < pattern.length; j++) {
            if (pattern[j] == 1) {
                if (nums[i + j + 1] <= nums[i + j])
                    return 0;
            } else if (pattern[j] == 0) {
                if (nums[i + j + 1] != nums[i + j])
                    return 0;
            } else {
                if (nums[i + j + 1] >= nums[i + j])
                    return 0;
            }
        }
        return 1;
    }
}

/*
 * Problem: 2488. Count Subarrays With Median K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-median-k/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int countSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                int[] diffs = new int[nums.length * 3 - 1];
                int diff = nums.length + k - 2;
                diffs[diff] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > k) {
                        diff++;
                    } else {
                        diff--;
                    }
                    diffs[diff]++;
                }
                diff = nums.length + k - 2;
                int res = 0;
                res += diffs[diff] + diffs[diff + 1];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > k) {
                        diff--;
                    } else {
                        diff++;
                    }
                    res += diffs[diff] + diffs[diff + 1];
                }
                return res;
            }
        }
        return -1;
    }
}

/*
 * Problem: 3171. Find Subarray With Bitwise OR Closest to K
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-subarray-with-bitwise-or-closest-to-k/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(Math.abs(nums[i] - k), res);
            for (int j = i - 1; j >= 0 && (nums[j] | nums[i]) != nums[j]; j--) {
                nums[j] |= nums[i];
                res = Math.min(Math.abs(nums[j] - k), res);
            }
        }
        return res;
    }
}

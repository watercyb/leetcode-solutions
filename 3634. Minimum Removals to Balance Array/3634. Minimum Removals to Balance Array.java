/*
 * Problem: 3634. Minimum Removals to Balance Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-removals-to-balance-array/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 0;
        int max = 0;
        for (int i = 0; j < nums.length; i++) {
            while (j < nums.length && (long) k * nums[i] >= nums[j]) {
                j++;
            }
            max = Math.max(j - i, max);
        }
        return nums.length - max;
    }
}

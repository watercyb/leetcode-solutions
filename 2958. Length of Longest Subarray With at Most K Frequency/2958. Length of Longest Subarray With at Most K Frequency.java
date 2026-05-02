/*
 * Problem: 2958. Length of Longest Subarray With at Most K Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if (k == nums.length)
            return nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max - min + 1];
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counts[nums[i] - min] == k) {
                res = Math.max(i - j, res);
                while (nums[j] != nums[i]) {
                    counts[nums[j] - min]--;
                    j++;
                }
                j++;
            } else {
                counts[nums[i] - min]++;
            }
        }
        return Math.max(nums.length - j, res);
    }
}

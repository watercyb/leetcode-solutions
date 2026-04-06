/*
 * Problem: 697. Degree of an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/degree-of-an-array/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        int[] left = new int[max + 1];
        int[] right = new int[max + 1];
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counts[nums[i]]++ == 0) {
                left[nums[i]] = i;
                right[nums[i]] = i;
            } else {
                right[nums[i]] = i;
            }
            maxCount = Math.max(counts[nums[i]], maxCount);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == maxCount) {
                res = Math.min(right[i] - left[i], res);
            }
        }
        return res + 1;
    }
}

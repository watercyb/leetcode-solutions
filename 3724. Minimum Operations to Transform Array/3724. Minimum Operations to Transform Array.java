/*
 * Problem: 3724. Minimum Operations to Transform Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-transform-array/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long res = 0;
        long offset = Integer.MAX_VALUE;
        int last = nums2[nums2.length - 1];
        for (int i = 0; i < nums1.length; i++) {
            int max = Math.max(nums1[i], nums2[i]);
            int min = nums1[i] + nums2[i] - max;
            if (last >= min && last <= max) {
                offset = 0;
            } else if (last < min) {
                offset = Math.min(offset, min - last);
            } else {
                offset = Math.min(offset, last - max);
            }
            res += max - min;
        }
        return res + offset + 1;
    }
}

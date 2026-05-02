/*
 * Problem: 2934. Minimum Operations to Maximize Last Elements in Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 1;
        int t1 = nums1[nums1.length - 1];
        int t2 = nums2[nums2.length - 1];
        for (int i = 0; i < nums1.length - 1; i++) {
            boolean b1 = nums1[i] <= t1 && nums2[i] <= t2;
            boolean b2 = nums2[i] <= t1 && nums1[i] <= t2;
            if (!b1 && b2) {
                a++;
            } else if (b1 && !b2) {
                b++;
            } else if (!b1 && !b2) {
                return -1;
            }
        }
        return Math.min(a, b);
    }
}

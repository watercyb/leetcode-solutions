/*
 * Problem: 2499. Minimum Total Cost to Make Arrays Unequal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-total-cost-to-make-arrays-unequal/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int[] counts = new int[nums1.length + 1];
        int count = 0;
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                counts[nums1[i]]++;
                count++;
                res += i;
            }
        }
        int oversized = -1;
        for (int i = 0; i <= nums1.length; i++) {
            if (2 * counts[i] > count) {
                oversized = i;
                break;
            }
        }
        if (oversized == -1) {
            return res;
        } else {
            int j = 0;
            for (int i = 2 * counts[oversized] - count; i > 0; i--) {
                while (j < nums1.length && (nums1[j] == nums2[j] || nums1[j] == oversized || nums2[j] == oversized)) {
                    j++;
                }
                if (j == nums1.length)
                    return -1;
                res += j;
                j++;
            }
            return res;
        }
    }
}

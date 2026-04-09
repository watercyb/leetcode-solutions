/*
 * Problem: 801. Minimum Swaps To Make Sequences Increasing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 1;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] <= nums1[i - 1] || nums2[i] <= nums2[i - 1]) {
                int temp = a;
                a = b;
                b = temp + 1;
            } else if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, b);
                b = a + 1;
            } else {
                b += 1;
            }
        }
        return Math.min(a, b);
    }
}

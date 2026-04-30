/*
 * Problem: 2771. Longest Non-decreasing Subarray From Two Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-non-decreasing-subarray-from-two-arrays/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int a = 1;
        int b = 1;
        int res = 1;
        for (int i = 1; i < nums1.length; i++) {
            int aNext = 1;
            int bNext = 1;
            if (nums1[i] >= nums1[i - 1])
                aNext = a + 1;
            if (nums1[i] >= nums2[i - 1])
                aNext = Math.max(aNext, b + 1);
            if (nums2[i] >= nums2[i - 1])
                bNext = b + 1;
            if (nums2[i] >= nums1[i - 1])
                bNext = Math.max(bNext, a + 1);
            a = aNext;
            b = bNext;
            res = Math.max(res, Math.max(a, b));
        }
        return res;
    }
}

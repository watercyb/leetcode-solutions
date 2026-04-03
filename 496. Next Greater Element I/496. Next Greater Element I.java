/*
 * Problem: 496. Next Greater Element I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/next-greater-element-i/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] idx = new int[10001];
        int[] MQ = new int[nums2.length + 1];
        MQ[0] = -1;
        int j = 1;
        for (int i = nums2.length - 1; i >= 0; i--) {
            idx[nums2[i]] = i;
            while (j > 1 && nums2[i] >= MQ[j - 1]) {
                j--;
            }
            MQ[j] = nums2[i];
            nums2[i] = MQ[j - 1];
            j++;
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums2[idx[nums1[i]]];
        }
        return res;
    }
}

/*
 * Problem: 3682. Minimum Index Sum of Common Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-index-sum-of-common-elements/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minimumSum(int[] nums1, int[] nums2) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] idx = new int[max - min + 1];
        Arrays.fill(idx, Integer.MAX_VALUE / 2);
        for (int i = nums1.length - 1; i >= 0; i--) {
            idx[nums1[i] - min] = i;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums2.length && i < res; i++) {
            int num = nums2[i] - min;
            if (num >= idx.length || num < 0 || i + idx[num] >= res)
                continue;
            res = i + idx[num];
        }
        if (res >= Integer.MAX_VALUE / 2)
            return -1;
        return res;
    }
}

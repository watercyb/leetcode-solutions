/*
 * Problem: 2541. Minimum Operations to Make Array Equal II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal-ii/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0)
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        long diff = 0;
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int dif = nums2[i] - nums1[i];
            if (dif % k != 0)
                return -1;
            if (dif > 0)
                res += dif;
            diff += dif;
        }
        if (diff != 0)
            return -1;
        return res / k;
    }
}

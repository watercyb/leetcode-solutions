/*
 * Problem: 3876. Construct Uniform Parity Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-uniform-parity-array-ii/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1[0] % 2;
        boolean isGood = true;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            if ((nums1[i] & 1) != n)
                isGood = false;
            min = Math.min(min, nums1[i]);
        }
        if (isGood)
            return true;
        return min % 2 == 1;
    }
}

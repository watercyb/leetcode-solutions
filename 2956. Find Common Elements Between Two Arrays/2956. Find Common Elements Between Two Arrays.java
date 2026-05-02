/*
 * Problem: 2956. Find Common Elements Between Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-common-elements-between-two-arrays/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] counts1 = new boolean[101];
        boolean[] counts2 = new boolean[101];
        for (int num : nums1) {
            counts1[num] = true;
        }
        for (int num : nums2) {
            counts2[num] = true;
        }
        int[] res = new int[2];
        for (int num : nums1) {
            if (counts2[num])
                res[0]++;
        }
        for (int num : nums2) {
            if (counts1[num])
                res[1]++;
        }
        return res;
    }
}

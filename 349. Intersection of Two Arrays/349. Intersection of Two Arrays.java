/*
 * Problem: 349. Intersection of Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-two-arrays/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] seen = new int[1001];
        for (int num : nums1) {
            seen[num] = 1;
        }
        int count = 0;
        for (int num : nums2) {
            if (seen[num] == 1) {
                seen[num] = 2;
                count++;
            }
        }
        int[] res = new int[count];
        int idx = 0;
        for (int i = 0; i < 1001; i++) {
            if (seen[i] == 2)
                res[idx++] = i;
        }
        return res;
    }
}

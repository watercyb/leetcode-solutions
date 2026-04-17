/*
 * Problem: 1460. Make Two Arrays Equal by Reversing Subarrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] counts = new int[1001];
        for (int num : arr) {
            counts[num]++;
        }
        for (int num : target) {
            if (counts[num]-- == 0)
                return false;
        }
        return true;
    }
}

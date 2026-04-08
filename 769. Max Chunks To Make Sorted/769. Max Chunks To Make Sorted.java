/*
 * Problem: 769. Max Chunks To Make Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-chunks-to-make-sorted/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (max == i) {
                res++;
                max = 0;
            }
        }
        return res;
    }
}

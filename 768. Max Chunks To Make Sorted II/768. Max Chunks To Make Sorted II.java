/*
 * Problem: 768. Max Chunks To Make Sorted II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] mins = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            min = Math.min(arr[i], min);
            mins[i] = min;
        }
        int max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max <= mins[i])
                res++;
            max = Math.max(arr[i], max);
        }
        return res;
    }
}

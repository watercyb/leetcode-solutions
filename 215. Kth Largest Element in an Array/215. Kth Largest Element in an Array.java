/*
 * Problem: 215. Kth Largest Element in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int idx = counts.length - 1;
        while (k > 0) {
            while (counts[idx] == 0) {
                idx--;
            }
            k -= counts[idx--];
        }
        return idx + 1 + min;
    }
}

/*
 * Problem: 2945. Find Maximum Non-decreasing Array Length
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-maximum-non-decreasing-array-length/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int findMaximumLength(int[] nums) {
        int[] counts = new int[nums.length + 1];
        long[] sums = new long[nums.length + 1];
        long[] diffs = new long[nums.length + 1];
        int k = 1;
        int j = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j < k && sum >= diffs[j]) {
                j++;
            }
            j--;
            long diff = 2 * sum - sums[j];
            while (k > 0 && diff <= diffs[k - 1]) {
                k--;
            }
            sums[k] = sum;
            counts[k] = counts[j] + 1;
            diffs[k++] = diff;
        }
        return counts[k-1];
    }
}

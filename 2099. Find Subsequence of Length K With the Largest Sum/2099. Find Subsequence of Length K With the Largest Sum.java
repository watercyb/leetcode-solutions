/*
 * Problem: 2099. Find Subsequence of Length K With the Largest Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int[] counts = new int[max - min + 1];
        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            counts[arr[i] - min]++;
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num : nums) {
            if (counts[num - min]-- > 0)
                res[idx++] = num;
        }
        return res;
    }
}

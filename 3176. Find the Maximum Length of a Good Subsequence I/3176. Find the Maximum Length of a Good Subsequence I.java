/*
 * Problem: 3176. Find the Maximum Length of a Good Subsequence I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-maximum-length-of-a-good-subsequence-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maximumLength(int[] nums, int k) {
        TreeMap<Integer, int[]> TM = new TreeMap<>();
        int res = 0;
        int[] max = new int[k + 1];
        for (int i = 0; i < nums.length; i++) {
            int[] arr = TM.getOrDefault(nums[i], new int[k + 1]);
            arr[0]++;
            for (int j = 1; j <= k; j++) {
                arr[j] = Math.max(arr[j] + 1, max[j - 1] + 1);
            }
            TM.put(nums[i], arr);
            for (int j = 0; j <= k; j++) {
                max[j] = Math.max(arr[j], max[j]);
            }
        }
        for (int i = 0; i <= k; i++) {
            res = Math.max(max[i], res);
        }
        return res;
    }
}

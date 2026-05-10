/*
 * Problem: 3763. Maximum Total Sum with Threshold Constraints
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-sum-with-threshold-constraints/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maxSum(int[] nums, int[] threshold) {
        int[][] arr = new int[nums.length][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[] { nums[i], threshold[i] };
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        long res = 0;
        for (int i = 0; i < arr.length && i + 1 >= arr[i][1]; i++) {
            res += arr[i][0];
        }
        return res;
    }
}

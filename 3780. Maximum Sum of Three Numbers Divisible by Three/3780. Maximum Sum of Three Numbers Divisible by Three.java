/*
 * Problem: 3780. Maximum Sum of Three Numbers Divisible by Three
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-sum-of-three-numbers-divisible-by-three/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maximumSum(int[] nums) {
        int[][] maxes = new int[3][3];
        for (int[] row : maxes) {
            Arrays.fill(row, Integer.MIN_VALUE / 3);
        }
        for (int num : nums) {
            int[] arr = maxes[num % 3];
            if (num > arr[0]) {
                arr[2] = arr[1];
                arr[1] = arr[0];
                arr[0] = num;
            } else if (num > arr[1]) {
                arr[2] = arr[1];
                arr[1] = num;
            } else if (num > arr[2]) {
                arr[2] = num;
            }
        }
        int res = 0;
        res = Math.max(res, maxes[0][0] + maxes[0][1] + maxes[0][2]);
        res = Math.max(res, maxes[1][0] + maxes[1][1] + maxes[1][2]);
        res = Math.max(res, maxes[0][0] + maxes[1][0] + maxes[2][0]);
        res = Math.max(res, maxes[2][0] + maxes[2][1] + maxes[2][2]);
        return res;
    }
}

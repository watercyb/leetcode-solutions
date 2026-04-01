/*
 * Problem: 312. Burst Balloons
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/burst-balloons/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        System.arraycopy(nums, 0, arr, 1, nums.length);
        arr[0] = 1;
        arr[nums.length + 1] = 1;
        int[][] DP = new int[arr.length][arr.length];
        for (int i = 2; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                int tmp=0;
                int pro=arr[j] * arr[j + i];
                for (int k = j + 1; k < j + i; k++) {
                    tmp = Math.max(DP[j][k] + DP[k][j + i] + arr[k] * pro, tmp);
                }
                DP[j][j + i] =tmp;
            }
        }
        return DP[0][arr.length-1];
    }
}

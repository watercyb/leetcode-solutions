/*
 * Problem: 2465. Number of Distinct Averages
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-distinct-averages/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int distinctAverages(int[] nums) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        int l = 0;
        int r = 100;
        boolean[] seens = new boolean[201];
        int res = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            while (counts[l] == 0) {
                l++;
            }
            while (counts[r] == 0) {
                r--;
            }
            counts[l]--;
            counts[r]--;
            if (!seens[r + l]) {
                seens[r + l] = true;
                res++;
            }
        }
        return res;
    }
}

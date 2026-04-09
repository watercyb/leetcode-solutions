/*
 * Problem: 887. Super Egg Drop
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/super-egg-drop/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int superEggDrop(int k, int n) {
        int[] DP = new int[k + 1];
        int res = 0;
        while (DP[k] < n) {
            for (int i = k; i > 0; i--) {
                DP[i] += DP[i - 1] + 1;
            }
            res++;
        }
        return res;
    }
}

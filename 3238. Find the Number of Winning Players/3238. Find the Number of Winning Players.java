/*
 * Problem: 3238. Find the Number of Winning Players
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-number-of-winning-players/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] counts = new int[n][11];
        for (int[] p : pick) {
            counts[p[0]][p[1]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int count : counts[i]) {
                if (count > i) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}

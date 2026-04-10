/*
 * Problem: 920. Number of Music Playlists
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-music-playlists/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] DP = new long[goal + 1][n + 1];
        DP[0][0] = 1;
        sol(DP, 0, n, goal, k);
        return (int) DP[goal][n];
    }

    public void sol(long[][] DP, int i, int n, int goal, int k) {
        int mod = 1_000_000_007;
        if (i == goal)
            return;
        int offset = Math.min(i, k);
        int r = Math.min(i + 1, n);
        int l = Math.max(n - (goal - i), 0);
        for (int j = r; j > l; j--) {
            DP[i + 1][j] = (DP[i][j] * (j - offset) + DP[i][j - 1] * (n - j + 1)) % mod;
        }
        sol(DP, i + 1, n, goal, k);
    }
}

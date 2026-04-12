/*
 * Problem: 1320. Minimum Distance to Type a Word Using Two Fingers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/?envType=daily-question&envId=2026-04-12
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public int minimumDistance(String word) {
        int[][] pos = new int[26][];
        int idx = 0;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5 && idx < 26; j++) {
                pos[idx++] = new int[] { i, j };
            }
        }
        int[] DP = new int[27];
        int prv = 0;
        for (char chr : word.toCharArray()) {
            chr -= 'A';
            int dist = getDist(pos, prv, chr);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= 26; i++) {
                min = Math.min(DP[i] + getDist(pos, i, chr), min);
                DP[i] += dist;
            }
            DP[prv] = Math.min(min, DP[prv]);
            prv = chr + 1;
        }
        int res = Integer.MAX_VALUE;
        for (int num : DP) {
            res = Math.min(num, res);
        }
        return res;
    }

    public int getDist(int[][] pos, int a, int b) {
        if (a == 0)
            return 0;
        return Math.abs(pos[a - 1][0] - pos[b][0]) + Math.abs(pos[a - 1][1] - pos[b][1]);
    }
}

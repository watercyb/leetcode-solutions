/*
 * Problem: 765. Couples Holding Hands
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/couples-holding-hands/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int minSwapsCouples(int[] row) {
        int[] positions = new int[row.length];
        for (int i = 0; i < row.length / 2; i++) {
            positions[row[2 * i]] = i;
            positions[row[2 * i + 1]] = i;
        }
        int res = 0;
        boolean[] seens = new boolean[row.length / 2];
        for (int i = 0; i < row.length / 2; i++) {
            if (!seens[i])
                res += dfs(row, positions, seens, i) - 1;
        }
        return res;
    }

    public int dfs(int[] row, int[] positions, boolean[] seens, int i) {
        if (seens[i])
            return 0;
        seens[i] = true;
        return dfs(row, positions, seens, positions[row[2 * i] ^ 1])
                + dfs(row, positions, seens, positions[row[2 * i + 1] ^ 1]) + 1;
    }
}

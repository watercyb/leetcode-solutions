/*
 * Problem: 174. Dungeon Game
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/dungeon-game/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int rl=dungeon.length - 1;
        int cl=dungeon[0].length - 1;
        boolean[][] seen = new boolean[dungeon.length][dungeon[0].length];
        seen[rl][cl] = true;
        if (dungeon[rl][cl] > 0)
            dungeon[rl][cl] = 0;
        return -dfs(seen, dungeon, 0, 0) + 1;
    }

    public int dfs(boolean[][] seen, int[][] dungeon, int i, int j) {
        if (i == dungeon.length || j == dungeon[0].length)
            return Integer.MIN_VALUE;
        if (seen[i][j])
            return dungeon[i][j];
        dungeon[i][j] += Math.max(dfs(seen, dungeon, i + 1, j), dfs(seen, dungeon, i, j + 1));
        if (dungeon[i][j] > 0)
            dungeon[i][j] = 0;
        seen[i][j] = true;
        return dungeon[i][j];
    }
}

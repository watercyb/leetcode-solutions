/*
 * Problem: 3283. Maximum Number of Moves to Kill All Pawns
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-moves-to-kill-all-pawns/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int maxMoves(int kx, int ky, int[][] positions) {
        int[][][] moves = new int[50][50][positions.length];
        for (int i = 0; i < positions.length; i++) {
            getMove(moves, positions[i], i);
        }
        return dfs(moves, positions, new int[1 << positions.length][positions.length], 0, kx, ky, 0, 0);
    }

    public int dfs(int[][][] moves, int[][] positions, int[][] meme, int h, int x, int y, int prv, int n) {
        if (n == positions.length)
            return 0;
        if (meme[h][prv] != 0)
            return meme[h][prv];
        if (n % 2 == 0) {
            int res = 0;
            for (int i = 0; i < positions.length; i++) {
                int mask = 1 << i;
                if ((h & mask) == 0) {
                    res = Math.max(
                            dfs(moves, positions, meme, h + mask, positions[i][0], positions[i][1], i, n + 1)
                                    + moves[x][y][i],
                            res);
                }
            }
            return meme[h][prv] = res;
        } else {
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < positions.length; i++) {
                int mask = 1 << i;
                if ((h & mask) == 0) {
                    res = Math.min(
                            dfs(moves, positions, meme, h + mask, positions[i][0], positions[i][1], i, n + 1)
                                    + moves[x][y][i],
                            res);
                }
            }
            return meme[h][prv] = res;
        }
    }

    int[][] directions = { { 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };

    public void getMove(int[][][] moves, int[] position, int i) {
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(position);
        moves[position[0]][position[1]][i] = -1;
        int stp = 1;
        while (!Qu.isEmpty()) {
            for (int j = Qu.size(); j > 0; j--) {
                int[] current = Qu.poll();
                for (int[] direction : directions) {
                    int x = current[0] + direction[0];
                    int y = current[1] + direction[1];
                    if (x >= 0 && x < 50 && y >= 0 && y < 50 && moves[x][y][i] == 0) {
                        moves[x][y][i] = stp;
                        Qu.offer(new int[] { x, y });
                    }
                }
            }
            stp++;
        }
    }
}

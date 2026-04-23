/*
 * Problem: 2056. Number of Valid Move Combinations On Chessboard
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int countCombinations(String[] pieces, int[][] positions) {
        directions = new int[3][][];
        directions[0] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        directions[1] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
                { -1, -1 } };
        directions[2] = new int[][] { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
        int[][] p = new int[pieces.length][3];
        for (int i = 0; i < pieces.length; i++) {
            int idx = 2;
            if (pieces[i].equals("rook")) {
                idx = 0;
            } else if (pieces[i].equals("queen")) {
                idx = 1;
            }
            p[i] = new int[] { positions[i][0], positions[i][1], idx };
        }
        int[][] d = new int[p.length][2];
        for (int i = 0; i < p.length; i++) {
            d[i] = new int[] { p[i][0], p[i][1] };
        }
        return dfs(p, new int[p.length][2], d, 0, 0);
    }

    int[][][] directions;

    int res = 0;

    public int dfs(int[][] p, int[][] dirt, int[][] d, int i, int n) {
        if (i == p.length) {
            if (run(p, dirt, d, n))
                return 1;
            return 0;
        }
        int res = dfs(p, dirt, d, i + 1, n);
        for (int j = 0; j < directions[p[i][2]].length; j++) {
            dirt[i] = directions[p[i][2]][j];
            for (int k = 1; k < 8; k++) {
                d[i][0] += dirt[i][0];
                d[i][1] += dirt[i][1];
                if (d[i][0] > 0 && d[i][0] <= 8 && d[i][1] > 0 && d[i][1] <= 8) {
                    res += dfs(p, dirt, d, i + 1, Math.max(k, n));
                } else {
                    break;
                }
            }
            d[i][0] = p[i][0];
            d[i][1] = p[i][1];
        }
        return res;
    }

    public boolean run(int[][] p, int[][] dirt, int[][] d, int n) {
        int[][] pClone = new int[p.length][];
        for (int i = 0; i < p.length; i++) {
            pClone[i] = p[i].clone();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p.length; j++) {
                if (pClone[j][0] != d[j][0] || pClone[j][1] != d[j][1]) {
                    pClone[j][0] += dirt[j][0];
                    pClone[j][1] += dirt[j][1];
                }
                if (!chk(pClone, j))
                    return false;
            }
        }
        return true;
    }

    public boolean chk(int[][] p, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if ((p[i][0] == p[j][0] && p[i][1] == p[j][1]))
                return false;
        }
        return true;
    }
}

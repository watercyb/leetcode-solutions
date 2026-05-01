/*
 * Problem: 2850. Minimum Moves to Spread Stones Over Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-spread-stones-over-grid/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minimumMoves(int[][] grid) {
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    a.add(new int[] { i, j });
                } else if (grid[i][j] == 0) {
                    b.add(new int[] { i, j });
                }
            }
        }
        if (a.size() == 1) {
            int[] pairA = a.getFirst();
            int res = 0;
            for (int[] pairB : b) {
                res += getDist(pairA, pairB);
            }
            return res;
        } else if (b.size() == 1) {
            int[] pairB = b.getFirst();
            int res = 0;
            for (int[] pairA : a) {
                res += getDist(pairA, pairB);
            }
            return res;
        }
        int[][] arr1 = new int[a.size()][3];
        for (int i = 0; i < arr1.length; i++) {
            int[] pairA = a.get(i);
            arr1[i] = new int[] { pairA[0], pairA[1], grid[pairA[0]][pairA[1]] - 1 };
        }
        int[][] arr2 = new int[b.size()][2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = b.get(i);
        }
        return dfs(arr1, arr2, 0);
    }

    public int dfs(int[][] a, int[][] b, int i) {
        if (i == b.length)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < a.length; j++) {
            if (a[j][2] > 0) {
                a[j][2]--;
                res = Math.min(dfs(a, b, i + 1) + getDist(a[j], b[i]), res);
                a[j][2]++;
            }
        }
        return res;
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

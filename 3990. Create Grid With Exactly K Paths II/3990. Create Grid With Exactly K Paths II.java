/*
 * Problem: 3990. Create Grid With Exactly K Paths II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/create-grid-with-exactly-k-paths-ii/
 * Language: java
 * Date: 2026-07-13
 */

class Solution {
    public List<String> createGrid(int k) {
        int[][] arr = new int[26][26];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                int p = C(i + j - 1 - 1, i - 1);
                arr[i][j] = p;
                if (p >= 1000)
                    break;
            }
        }
        seens = new boolean[27][k + 1];
        dfs(arr, 26, k);
        char[][] chrs = new char[25][25];
        for (char[] row : chrs) {
            Arrays.fill(row, '#');
            row[0] = '.';
            row[24] = '.';
        }
        int idx = 0;
        for (int[] pair : list) {
            int x = pair[0];
            int y = pair[1];
            for (int i = idx; i < idx + x; i++) {
                for (int j = 0; j < y; j++) {
                    chrs[i][j] = '.';
                }
            }
            for (int i = 1; i < 24; i++) {
                chrs[idx + x - 1][i] = '.';
            }
            idx += x + 1;
        }
        List<String> res = new ArrayList<>();
        for (char[] row : chrs) {
            res.add(new String(row));
        }
        return res;
    }

    List<int[]> list = new ArrayList<>();
    boolean[][] seens;

    public boolean dfs(int[][] arr, int x, int k) {
        if (seens[x][k])
            return false;
        seens[x][k] = true;
        if (k == 0)
            return true;
        for (int i = x - 1; i >= 1; i--) {
            for (int j = 2; j <= 25 && arr[i][j] <= k; j++) {
                if (j == 24)
                    continue;
                if (dfs(arr, x - i - 1, k - arr[i][j])) {
                    list.add(new int[] { i, j });
                    return true;
                }
            }
        }
        return false;
    }

    public int C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long c = 1;
        long d = 1;
        for (int i = 1; i <= b; i++) {
            c *= a;
            d *= i;
            a--;
        }
        if (c / d > 1000)
            return 1001;
        return (int) (c / d);
    }
}

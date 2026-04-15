/*
 * Problem: 1222. Queens That Can Attack the King
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/queens-that-can-attack-the-king/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int r = 8;
        int c = 8;
        boolean[] q = new boolean[r * c];
        for (int[] queen : queens) {
            q[queen[0] * c + queen[1]] = true;
        }
        List<List<Integer>> res = new ArrayList<>();
        int x = king[0] - 1;
        int y = king[1];
        while (x >= 0) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            x--;
        }
        x = king[0] + 1;
        y = king[1];
        while (x < r) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            x++;
        }
        x = king[0];
        y = king[1] - 1;
        while (y >= 0) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            y--;
        }
        x = king[0];
        y = king[1] + 1;
        while (y < c) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            y++;
        }
        x = king[0] - 1;
        y = king[1] - 1;
        while (x >= 0 && y >= 0) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            x--;
            y--;
        }
        x = king[0] + 1;
        y = king[1] + 1;
        while (x < r && y < c) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            x++;
            y++;
        }
        x = king[0] + 1;
        y = king[1] - 1;
        while (x < r && y >= 0) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            x++;
            y--;
        }
        x = king[0] - 1;
        y = king[1] + 1;
        while (x >= 0 && y < c) {
            if (q[x * c + y]) {
                res.add(Arrays.asList(x, y));
                break;
            }
            x--;
            y++;
        }
        return res;
    }
}

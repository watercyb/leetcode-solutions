/*
 * Problem: 3562. Maximum Profit from Trading Stocks with Discounts
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-profit-from-trading-stocks-with-discounts/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.budget = budget;
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] h : hierarchy) {
            lists[h[0] - 1].add(h[1] - 1);
        }
        int[][] res = dfs(lists, 0);
        int max = 0;
        for (int i = 0; i < res[0].length; i++) {
            max = Math.max(res[0][i] - i, max);
        }
        return max;
    }

    int[] present;
    int[] future;
    int budget;

    public void cmb(int[][] DP, int[][] resNext) {
        for (int i = DP[0].length - 1; i >= 0; i--) {
            if (DP[0][i] < 0)
                continue;
            for (int j = DP[0].length - 1 - i; j >= 0; j--) {
                DP[0][i + j] = Math.max(DP[0][i] + resNext[0][j], DP[0][i + j]);
            }
        }
        for (int i = DP[0].length - 1; i >= 0; i--) {
            if (DP[1][i] < 0)
                continue;
            for (int j = DP[0].length - 1 - i; j >= 0; j--) {
                DP[1][i + j] = Math.max(DP[1][i] + resNext[1][j], DP[1][i + j]);
            }
        }
    }

    int min = Integer.MIN_VALUE / 2;

    public int[][] dfs(List<Integer>[] lists, int idx) {
        int[][] DP = getDP();
        for (int next : lists[idx]) {
            cmb(DP, dfs(lists, next));
        }
        DP[2] = DP[0].clone();
        for (int i = 0; i <= budget; i++) {
            if (i >= present[idx])
                DP[0][i] = Math.max(DP[1][i - present[idx]] + future[idx], DP[0][i]);
            int half = present[idx] / 2;
            if (i >= half)
                DP[2][i] = Math.max(DP[1][i - half] + future[idx], DP[2][i]);
        }
        return new int[][] { DP[0], DP[2] };
    }

    public int[][] getDP() {
        int[][] res = new int[3][budget + 1];
        Arrays.fill(res[0], min);
        Arrays.fill(res[1], min);
        res[0][0] = 0;
        res[1][0] = 0;
        return res;
    }
}

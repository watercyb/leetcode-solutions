/*
 * Problem: 2920. Maximum Points After Collecting Coins From All Nodes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-points-after-collecting-coins-from-all-nodes/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        List<Integer>[] lists = new ArrayList[coins.length];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        int max = 0;
        for (int coin : coins) {
            max = Math.max(coin, max);
        }
        int[][] meme = new int[32 - Integer.numberOfLeadingZeros(max)][coins.length];
        for (int[] row : meme) {
            Arrays.fill(row, -1);
        }
        return dfs(links, meme, coins, 0, -1, 0, k);
    }

    public int dfs(int[][] links, int[][] meme, int[] coins, int i, int prv, int factor, int k) {
        if (factor == meme.length)
            return 0;
        if (meme[factor][i] != -1)
            return meme[factor][i];
        int coin = coins[i] >> factor;
        int res = 0;
        int sum = 0;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            sum += Math.max(dfs(links, meme, coins, next, i, factor, k), 0);
        }
        res = Math.max(sum + coin - k, res);
        sum = 0;
        for (int next : links[i]) {
            if (next == prv)
                continue;
            sum += Math.max(dfs(links, meme, coins, next, i, factor + 1, k), 0);
        }
        res = Math.max(sum + coin / 2, res);
        return meme[factor][i] = res;
    }
}

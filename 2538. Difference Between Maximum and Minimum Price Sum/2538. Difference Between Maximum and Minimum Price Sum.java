/*
 * Problem: 2538. Difference Between Maximum and Minimum Price Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/difference-between-maximum-and-minimum-price-sum/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[n][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        long[] sums = new long[n];
        dfs(links, price, sums, 0, -1, 0);
        dfsRev(links, price, sums, 0, -1, 0);
        long res = 0;
        for (long sum : sums) {
            res = Math.max(res, sum);
        }
        return res;
    }

    public long dfs(int[][] links, int[] price, long[] sums, int i, int prv, long sum) {
        long nextSum = 0;
        for (int next : links[i]) {
            if (next != prv)
                nextSum = Math.max(nextSum, dfs(links, price, sums, next, i, Math.max(sum, nextSum) + price[i]));
        }
        sums[i] = Math.max(sum, nextSum);
        return nextSum + price[i];
    }

    public long dfsRev(int[][] links, int[] price, long[] sums, int i, int prv, long sum) {
        long nextSum = 0;
        for (int j = links[i].length - 1; j >= 0; j--) {
            int next = links[i][j];
            if (next != prv)
                nextSum = Math.max(nextSum, dfsRev(links, price, sums, next, i, Math.max(sum, nextSum) + price[i]));
        }
        sums[i] = Math.max(sums[i], Math.max(sum, nextSum));
        return nextSum + price[i];
    }
}

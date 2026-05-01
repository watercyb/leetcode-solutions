/*
 * Problem: 2872. Maximum Number of K-Divisible Components
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-k-divisible-components/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] links = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
        }
        dfs(links, new boolean[n], values, 0, k);
        return res;
    }

    int res = 0;

    public long dfs(List<Integer>[] links, boolean[] seens, int[] values, int i, int k) {
        seens[i] = true;
        long sum = values[i];
        for (int next : links[i]) {
            if (!seens[next])
                sum += dfs(links, seens, values, next, k);
        }
        seens[i] = false;
        if (sum % k == 0) {
            res++;
            return 0;
        } else {
            return sum;
        }
    }
}

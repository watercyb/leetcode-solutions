/*
 * Problem: 1377. Frog Position After T Seconds
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/frog-position-after-t-seconds/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] links = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
        }
        return dfs(links, new boolean[n + 1], 1, target, t);
    }

    public double dfs(List<Integer>[] links, boolean[] seens, int i, int target, int t) {
        if (t == 0) {
            if (i == target)
                return 1;
            return 0;
        }
        seens[i] = true;
        List<Integer> list = links[i];
        int count = 0;
        for (int next : list) {
            if (!seens[next])
                count++;
        }
        if (count == 0) {
            if (i == target)
                return 1;
            return 0;
        } else {
            double res = 0;
            for (int next : list) {
                if (seens[next])
                    continue;
                res += dfs(links, seens, next, target, t - 1);
            }
            return res / count;
        }
    }
}

/*
 * Problem: 3367. Maximize Sum of Weights after Edge Removals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        int[] counts = new int[n];
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }
        if (max <= k) {
            long sum = 0;
            for (int[] edge : edges) {
                sum += edge[2];
            }
            return sum;
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        return dfs(links, 0, -1, k)[1];
    }

    public long[] dfs(int[][][] links, int i, int prv, int k) {
        List<Long> list = new ArrayList<>();
        long prvW = 0;
        long sum = 0;
        for (int[] next : links[i]) {
            if (next[0] == prv) {
                prvW = next[1];
            } else {
                long[] resNext = dfs(links, next[0], i, k);
                sum += resNext[1];
                list.add(resNext[0]);
            }
        }
        Collections.sort(list, (a, b) -> Long.compare(b, a));
        for (int j = 0; j < Math.min(list.size(), k - 1); j++) {
            sum += Math.max(list.get(j), 0);
        }
        long b = k - 1 < list.size() ? Math.max(list.get(k - 1), 0) : 0;
        return new long[] { prvW - b, sum + b };
    }
}

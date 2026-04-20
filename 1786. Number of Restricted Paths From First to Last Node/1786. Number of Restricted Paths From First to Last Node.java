/*
 * Problem: 1786. Number of Restricted Paths From First to Last Node
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        int mod = 1_000_000_007;
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            lists[a].add(new int[] { b, edge[2] });
            lists[b].add(new int[] { a, edge[2] });
        }
        int[] stps = new int[n];
        Arrays.fill(stps, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { n - 1, 0 });
        stps[n - 1] = 0;
        long[] counts = new long[n];
        counts[n - 1] = 1;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            if (current[1] > stps[current[0]])
                continue;
            long sum = counts[current[0]] % mod;
            for (int[] next : lists[current[0]]) {
                if (stps[next[0]] > current[1] + next[1]) {
                    stps[next[0]] = current[1] + next[1];
                    PQ.offer(new int[] { next[0], current[1] + next[1] });
                }
                if (stps[next[0]] > current[1])
                    counts[next[0]] = counts[next[0]] + sum;
            }
        }
        return (int) (counts[0] % mod);
    }
}

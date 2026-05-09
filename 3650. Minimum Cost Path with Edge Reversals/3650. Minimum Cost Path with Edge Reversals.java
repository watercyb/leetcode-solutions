/*
 * Problem: 3650. Minimum Cost Path with Edge Reversals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], 2 * edge[2] });
        }
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { 0, 0 });
        steps[0] = 0;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[0];
            int stp = current[1];
            if (steps[idx] != stp)
                continue;
            if (idx == n - 1)
                return stp;
            for (int[] next : lists[idx]) {
                int idxNext = next[0];
                int cost = stp + next[1];
                if (steps[idxNext] > cost) {
                    steps[idxNext] = cost;
                    PQ.offer(new int[] { idxNext, cost });
                }
            }
        }
        return -1;
    }
}

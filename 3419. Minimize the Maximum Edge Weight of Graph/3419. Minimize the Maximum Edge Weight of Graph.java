/*
 * Problem: 3419. Minimize the Maximum Edge Weight of Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-the-maximum-edge-weight-of-graph/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        List<int[]>[] links = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            links[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] seens = new boolean[n];
        PQ.offer(new int[] { 0, 0 });
        int res = 0;
        int count = 0;
        while (!PQ.isEmpty()) {
            while (!PQ.isEmpty() && seens[PQ.peek()[0]]) {
                PQ.poll();
            }
            if (PQ.isEmpty())
                break;
            int[] current = PQ.poll();
            seens[current[0]] = true;
            res = Math.max(current[1], res);
            count++;
            for (int[] next : links[current[0]]) {
                if (seens[next[0]])
                    continue;
                PQ.offer(next);
            }
        }
        if (count < n)
            return -1;
        return res;
    }
}

/*
 * Problem: 3112. Minimum Time to Visit Disappearing Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-visit-disappearing-nodes/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int[] res = disappear.clone();
        res[0] = 0;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PQ.offer(new int[] { 0, 0 });
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[1];
            int time = current[0];
            if (res[idx] != time)
                continue;
            for (int[] next : lists[idx]) {
                int nextIdx = next[0];
                int nextTime = time + next[1];
                if (nextTime >= res[nextIdx])
                    continue;
                res[nextIdx] = nextTime;
                PQ.offer(new int[] { nextTime, nextIdx });
            }
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == disappear[i])
                res[i] = -1;
        }
        return res;
    }
}

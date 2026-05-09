/*
 * Problem: 3604. Minimum Time to Reach Destination in Directed Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-time-to-reach-destination-in-directed-graph/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minTime(int n, int[][] edges) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2], edge[3] });
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PQ.offer(new int[] { 0, 0 });
        int[] times = new int[n];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[0] = 0;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int time = current[0];
            int idx = current[1];
            if (times[idx] != time)
                continue;
            if (idx == n - 1)
                return time;
            for (int[] next : lists[idx]) {
                int nextIdx = next[0];
                if (time > next[2])
                    continue;
                int nextTime = Math.max(time, next[1]) + 1;
                if (times[nextIdx] <= nextTime)
                    continue;
                PQ.offer(new int[] { nextTime, nextIdx });
                times[nextIdx] = nextTime;
            }
        }
        return -1;
    }
}

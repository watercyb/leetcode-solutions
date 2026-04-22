/*
 * Problem: 1928. Minimum Cost to Reach Destination in Time
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        List<int[]>[] lists = new ArrayList[passingFees.length];
        for (int i = 0; i < passingFees.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        int[] times = new int[passingFees.length];
        Arrays.fill(times, maxTime + 1);
        times[0] = 0;
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { 0, passingFees[0], 0 });
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[0];
            int cost = current[1];
            int time = current[2];
            for (int[] next : lists[idx]) {
                int idxNext = next[0];
                int costNext = cost + passingFees[idxNext];
                int timeNext = time + next[1];
                if (timeNext >= times[idxNext])
                    continue;
                if (idxNext == passingFees.length - 1)
                    return costNext;
                times[idxNext] = timeNext;
                PQ.offer(new int[] { idxNext, costNext, timeNext });
            }
        }
        return -1;
    }
}

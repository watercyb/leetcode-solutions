/*
 * Problem: 3977. Minimum Time to Reach Target With Limited Power
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-reach-target-with-limited-power/
 * Language: java
 * Date: 2026-06-29
 */

class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        int[] counts = new int[n];
        for (int[] edge : edges) {
            counts[edge[0]]++;
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]][];
        }
        for (int[] edge : edges) {
            links[edge[0]][--counts[edge[0]]] = new int[] { edge[1], edge[2] };
        }
        PriorityQueue<long[]> PQ = new PriorityQueue<>(
                (a, b) -> a[2] == b[2] ? Long.compare(b[1], a[1]) : Long.compare(a[2], b[2]));
        int[] powers = new int[n];
        Arrays.fill(powers, -1);
        PQ.offer(new long[] { source, power, 0 });
        while (!PQ.isEmpty()) {
            long[] current = PQ.poll();
            int idx = (int) current[0];
            int p = (int) current[1];
            long t = current[2];
            if (p <= powers[idx])
                continue;
            if (idx == target)
                return new long[] { t, (long) p };
            powers[idx] = p;
            p -= cost[idx];
            if (p < 0)
                continue;
            for (int[] next : links[idx]) {
                int idxNext = next[0];
                long tNext = t + next[1];
                PQ.offer(new long[] { idxNext, p, tNext });
            }
        }
        return new long[] { -1, -1 };
    }
}

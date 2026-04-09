/*
 * Problem: 871. Minimum Number of Refueling Stops
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        int pos = startFuel;
        int idx = 0;
        int res = 0;
        while (pos < target) {
            while (idx < stations.length && stations[idx][0] <= pos) {
                PQ.offer(stations[idx][1]);
                idx++;
            }
            if (PQ.isEmpty())
                break;
            pos += PQ.poll();
            res++;
        }
        if (pos >= target)
            return res;
        return -1;
    }
}

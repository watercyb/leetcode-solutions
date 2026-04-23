/*
 * Problem: 2054. Two Best Non-Overlapping Events
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/two-best-non-overlapping-events/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int res = 0;
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            while (!PQ.isEmpty() && PQ.peek()[1] < events[i][0]) {
                max = Math.max(PQ.poll()[2], max);
            }
            res = Math.max(events[i][2] + max, res);
            if (events[i][2] > max)
                PQ.offer(events[i]);
        }
        return res;
    }
}

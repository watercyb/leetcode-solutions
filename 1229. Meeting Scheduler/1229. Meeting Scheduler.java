/*
 * Problem: 1229. Meeting Scheduler
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/meeting-scheduler/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration)
                PQ.offer(slot);
        }
        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration)
                PQ.offer(slot);
        }
        int[] a = PQ.poll();
        while (!PQ.isEmpty()) {
            int[] b = PQ.peek();
            if (a[1] - b[0] >= duration)
                return Arrays.asList(b[0], b[0] + duration);
            a = PQ.poll();
        }
        return new ArrayList<>();
    }
}

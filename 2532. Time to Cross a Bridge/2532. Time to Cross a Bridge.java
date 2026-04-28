/*
 * Problem: 2532. Time to Cross a Bridge
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/time-to-cross-a-bridge/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<int[]> PQLeft = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> PQLeft1 = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < time.length; i++) {
            PQLeft1.offer(new int[] { 0, (time[i][0] + time[i][2]) * k + i, i });
        }
        PriorityQueue<int[]> PQRight = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> PQRight1 = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int t = 0;
        int[] bridge = null;
        boolean isToLeft = false;
        int rightN = n;
        while (n > 0) {
            while (!PQRight.isEmpty() && PQRight.peek()[0] <= t) {
                PQRight1.offer(PQRight.poll());
            }
            while (!PQLeft.isEmpty() && PQLeft.peek()[0] <= t) {
                PQLeft1.offer(PQLeft.poll());
            }
            if (bridge != null) {
                if (isToLeft) {
                    n--;
                    if (n == 0)
                        return t;
                    bridge[0] = t + time[bridge[2]][3];
                    PQLeft.offer(bridge);
                    bridge = null;
                } else {
                    rightN--;
                    bridge[0] = t + time[bridge[2]][1];
                    PQRight.offer(bridge);
                    bridge = null;
                }
            }
            if (!PQRight1.isEmpty()) {
                bridge = PQRight1.poll();
                isToLeft = true;
                t += time[bridge[2]][2];
            } else if (!PQLeft1.isEmpty() && rightN > 0) {
                bridge = PQLeft1.poll();
                t += time[bridge[2]][0];
                isToLeft = false;
            } else {
                int a = PQRight.isEmpty() ? Integer.MAX_VALUE : PQRight.peek()[0];
                int b = PQLeft.isEmpty() ? Integer.MAX_VALUE : PQLeft.peek()[0];
                if (b < a && rightN > 0) {
                    t = b;
                } else {
                    t = a;
                }
            }
        }
        return t;
    }
}

/*
 * Problem: 3341. Find Minimum Time to Reach Last Room I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PQ.offer(new int[] { 0, 0, 0 });
        boolean[][] seens = new boolean[moveTime.length][moveTime[0].length];
        seens[0][0] = true;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int x = current[1];
            int y = current[2];
            int stp = current[0];
            if (x == moveTime.length - 1 && y == moveTime[0].length - 1)
                return stp;
            if (x > 0 && !seens[x - 1][y]) {
                seens[x - 1][y] = true;
                PQ.offer(new int[] { Math.max(stp, moveTime[x - 1][y]) + 1, x - 1, y });
            }
            if (x < moveTime.length - 1 && !seens[x + 1][y]) {
                seens[x + 1][y] = true;
                PQ.offer(new int[] { Math.max(stp, moveTime[x + 1][y]) + 1, x + 1, y });
            }
            if (y > 0 && !seens[x][y - 1]) {
                seens[x][y - 1] = true;
                PQ.offer(new int[] { Math.max(stp, moveTime[x][y - 1]) + 1, x, y - 1 });
            }
            if (y < moveTime[0].length - 1 && !seens[x][y + 1]) {
                seens[x][y + 1] = true;
                PQ.offer(new int[] { Math.max(stp, moveTime[x][y + 1]) + 1, x, y + 1 });
            }
        }
        return -1;
    }
}

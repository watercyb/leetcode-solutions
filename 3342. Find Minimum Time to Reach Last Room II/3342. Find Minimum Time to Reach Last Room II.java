/*
 * Problem: 3342. Find Minimum Time to Reach Last Room II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PQ.offer(new int[] { 0, 0, 0, 1 });
        boolean[][] seens = new boolean[moveTime.length][moveTime[0].length];
        seens[0][0] = true;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int x = current[1];
            int y = current[2];
            int stp = current[0];
            int type = current[3];
            if (x == moveTime.length - 1 && y == moveTime[0].length - 1)
                return stp;
            if (x > 0 && !seens[x - 1][y]) {
                PQ.offer(new int[] { Math.max(stp, moveTime[x - 1][y]) + 2 - type, x - 1, y, 1 - type });
                seens[x - 1][y] = true;
            }
            if (x < moveTime.length - 1 && !seens[x + 1][y]) {
                PQ.offer(new int[] { Math.max(stp, moveTime[x + 1][y]) + 2 - type, x + 1, y, 1 - type });
                seens[x + 1][y] = true;
            }
            if (y > 0 && !seens[x][y - 1]) {
                PQ.offer(new int[] { Math.max(stp, moveTime[x][y - 1]) + 2 - type, x, y - 1, 1 - type });
                seens[x][y - 1] = true;
            }
            if (y < moveTime[0].length - 1 && !seens[x][y + 1]) {
                PQ.offer(new int[] { Math.max(stp, moveTime[x][y + 1]) + 2 - type, x, y + 1, 1 - type });
                seens[x][y + 1] = true;
            }
        }
        return -1;
    }
}

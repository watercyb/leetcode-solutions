/*
 * Problem: 286. Walls and Gates
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/walls-and-gates/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        Deque<int[]> Dq = new ArrayDeque<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    Dq.offerLast(new int[] { i, j });
            }
        }
        while (!Dq.isEmpty()) {
            int[] tmp = Dq.pollFirst();
            int stp = rooms[tmp[0]][tmp[1]] + 1;
            for (int[] dir : dirs) {
                int x = tmp[0] + dir[0];
                int y = tmp[1] + dir[1];
                if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] > stp) {
                    rooms[x][y] = stp;
                    Dq.offerLast(new int[] { x, y });
                }
            }
        }
    }
}

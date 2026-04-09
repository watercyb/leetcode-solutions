/*
 * Problem: 874. Walking Robot Simulation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/walking-robot-simulation/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int idx = 0;
        HashSet<Integer> HS = new HashSet<>();
        for (int[] obstacle : obstacles) {
            HS.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int max = 0;
        int x = 0;
        int y = 0;
        for (int command : commands) {
            if (command == -1) {
                idx = (idx + 1) % 4;
            } else if (command == -2) {
                idx = (idx + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    x += directions[idx][0];
                    y += directions[idx][1];
                    if (HS.contains(x * 60001 + y)) {
                        x -= directions[idx][0];
                        y -= directions[idx][1];
                        break;
                    }
                }
                max = Math.max(x * x + y * y, max);
            }
        }
        return max;
    }
}

/*
 * Problem: 1041. Robot Bounded In Circle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/robot-bounded-in-circle/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int idx = 0;
        int[] position = { 0, 0 };
        for (char chr : instructions.toCharArray()) {
            if (chr == 'G') {
                position[0] += directions[idx][0];
                position[1] += directions[idx][1];
            } else if (chr == 'L') {
                idx = (idx + 3) % 4;
            } else if (chr == 'R') {
                idx = (idx + 1) % 4;
            }
        }
        return (position[0] == 0 && position[1] == 0) || idx != 0;
    }
}

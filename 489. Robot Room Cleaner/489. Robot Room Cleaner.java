/*
 * Problem: 489. Robot Room Cleaner
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/robot-room-cleaner/
 * Language: java
 * Date: 2026-04-03
 */

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 * // Returns true if the cell in front is open and robot moves into the cell.
 * // Returns false if the cell in front is blocked and robot stays in the
 * current cell.
 * public boolean move();
 *
 * // Robot will stay in the same cell after calling turnLeft/turnRight.
 * // Each turn will be 90 degrees.
 * public void turnLeft();
 * public void turnRight();
 *
 * // Clean the current cell.
 * public void clean();
 * }
 */

class Solution {
    boolean[] cleaned = new boolean[201 * 401];
    int idx = 100 * 401 + 200;

    public void cleanRoom(Robot robot) {
        dfs(robot, 401, 1);
    }

    public void dfs(Robot robot, int i, int j) {
        robot.clean();
        cleaned[idx] = true;
        idx += i;
        if (!cleaned[idx] && robot.move()) {
            dfs(robot, i, j);
            robot.turnRight();
        } else {
            robot.turnLeft();
            idx -= i;
        }
        idx += j;
        if (!cleaned[idx] && robot.move()) {
            dfs(robot, j, -i);
        } else {
            robot.turnRight();
            robot.turnRight();
            idx -= j;
        }
        idx -= j;
        if (!cleaned[idx] && robot.move()) {
            dfs(robot, -j, i);
            robot.turnLeft();
        } else {
            robot.turnRight();
            idx += j;
        }
        idx -= i;
        robot.move();
        if (!cleaned[idx])
            dfs(robot, -i, -j);
    }
}

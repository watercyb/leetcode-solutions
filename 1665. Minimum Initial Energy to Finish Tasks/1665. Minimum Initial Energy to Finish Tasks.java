/*
 * Problem: 1665. Minimum Initial Energy to Finish Tasks
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - b[1] + b[0]);
        int res = 0;
        for (int[] task : tasks) {
            res = Math.max(res + task[0], task[1]);
        }
        return res;
    }
}

/*
 * Problem: 2432. The Employee That Worked on the Longest Task
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/the-employee-that-worked-on-the-longest-task/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = 0;
        int res = 0;
        int prv = 0;
        for (int[] log : logs) {
            if (log[1] - prv > max || (log[1] - prv == max && res > log[0])) {
                max = log[1] - prv;
                res = log[0];
            }
            prv = log[1];
        }
        return res;
    }
}

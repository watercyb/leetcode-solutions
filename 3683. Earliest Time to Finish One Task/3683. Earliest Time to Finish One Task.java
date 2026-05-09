/*
 * Problem: 3683. Earliest Time to Finish One Task
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/earliest-time-to-finish-one-task/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int earliestTime(int[][] tasks) {
        int res = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            res = Math.min(res, task[0] + task[1]);
        }
        return res;
    }
}

/*
 * Problem: 621. Task Scheduler
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/task-scheduler/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int['Z' + 1];
        for (char chr : tasks) {
            counts[chr]++;
        }
        int max = 0;
        int count = 0;
        for (int i = 'A'; i <= 'Z'; i++) {
            if (counts[i] > max) {
                count = 1;
                max = counts[i];
            } else if (counts[i] == max) {
                count++;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }

}

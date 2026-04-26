/*
 * Problem: 2365. Task Scheduler II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/task-scheduler-ii/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        HashMap<Integer, Long> HM = new HashMap<>();
        for (int task : tasks) {
            long t = HM.getOrDefault(task, 0l);
            if (t > res)
                res = t;
            res++;
            HM.put(task, res + space);
        }
        return res;
    }
}

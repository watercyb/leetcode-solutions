/*
 * Problem: 2323. Find Minimum Time to Finish All Jobs II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs-ii/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        countingSort(jobs);
        countingSort(workers);
        int res = 0;
        for (int i = 0; i < jobs.length; i++) {
            res = Math.max((jobs[i] + workers[i] - 1) / workers[i], res);
        }
        return res;
    }

    public void countingSort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (counts[idx] == 0) {
                idx++;
            }
            nums[i] = idx;
            counts[idx]--;
        }
    }
}

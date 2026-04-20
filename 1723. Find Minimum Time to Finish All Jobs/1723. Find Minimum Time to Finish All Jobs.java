/*
 * Problem: 1723. Find Minimum Time to Finish All Jobs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int l = jobs[jobs.length - 1];
        int r = 0;
        for (int job : jobs) {
            r += job;
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (dfs(jobs, new int[k], jobs.length - 1, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean dfs(int[] jobs, int[] workers, int i, int mid) {
        if (i == -1)
            return true;
        for (int j = 0; j < workers.length; j++) {
            if (workers[j] + jobs[i] <= mid) {
                workers[j] += jobs[i];
                if (dfs(jobs, workers, i - 1, mid))
                    return true;
                workers[j] -= jobs[i];
            }
            if (workers[j] == 0)
                break;
        }
        return false;
    }
}

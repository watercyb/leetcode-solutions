/*
 * Problem: 2071. Maximum Number of Tasks You Can Assign
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int l = 0;
        int r = Math.min(workers.length, tasks.length) + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(tasks, workers, pills, strength, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int[] arr = new int[mid];
        int l = 0;
        int r = 0;
        int i = workers.length - mid;
        int j = 0;
        while (j < mid) {
            if (workers[i] >= tasks[j]) {
                i++;
                j++;
                continue;
            }
            if (l < r && workers[i] >= arr[l]) {
                i++;
                l++;
                continue;
            }
            if (pills > 0 && (workers[i] + strength >= tasks[j] || l < r)) {
                while (j < mid && workers[i] + strength >= tasks[j]) {
                    arr[r++] = tasks[j++];
                }
                pills--;
                r--;
                i++;
                continue;
            }
            return false;
        }
        while (i < workers.length) {
            if (workers[i] >= arr[l]) {
                i++;
                l++;
            } else if (pills > 0) {
                pills--;
                i++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}

/*
 * Problem: 2589. Minimum Time to Complete All Tasks
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-complete-all-tasks/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] == b[1]?b[2]-a[2]:a[1]-b[1]);
        int max = tasks[tasks.length - 1][1];
        boolean[] used = new boolean[max + 1];
        BIT = new int[max + 1];
        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            int count = get(tasks[i][1]) - get(tasks[i][0] - 1);
            int diff = tasks[i][2] - count;
            if (diff > 0) {
                res+=diff;
                for (int j = tasks[i][1]; diff > 0; j--) {
                    if (!used[j]) {
                        used[j] = true;
                        insert(j);
                        diff--;
                    }
                }
            }
        }
        return res;
    }

    int[] BIT;

    public void insert(int i) {
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}

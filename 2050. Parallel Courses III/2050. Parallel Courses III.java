/*
 * Problem: 2050. Parallel Courses III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/parallel-courses-iii/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] needs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            needs[i] = time[i - 1];
        }
        for (boolean changed = true;changed;) {
            changed = false;
            for (int i = 0; i < relations.length; i++) {
                if (needs[relations[i][0]] + time[relations[i][1] - 1] > needs[relations[i][1]]) {
                    needs[relations[i][1]] = needs[relations[i][0]] + time[relations[i][1] - 1];
                    changed = true;
                }
            }
            for (int i = relations.length - 1; i >= 0; i--) {
                if (needs[relations[i][0]] + time[relations[i][1] - 1] > needs[relations[i][1]]) {
                    needs[relations[i][1]] = needs[relations[i][0]] + time[relations[i][1] - 1];
                    changed = true;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(needs[i], max);
        }
        return max;
    }
}

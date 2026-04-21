/*
 * Problem: 1894. Find the Student that Will Replace the Chalk
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long[] sums = new long[chalk.length];
        sums[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            sums[i] = sums[i - 1] + chalk[i];
        }
        k %= sums[chalk.length - 1];
        int l = -1;
        int r = chalk.length - 1;
        while (l < r) {
            int mid = ((l + r + 1) >>> 1);
            if (sums[mid] > k) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l + 1;
    }
}

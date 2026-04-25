/*
 * Problem: 2272. Substring With Largest Variance
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/substring-with-largest-variance/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int largestVariance(String s) {
        char[] chrs = s.toCharArray();
        int[][] sums = new int[26][26];
        int[][] mins = new int[26][26];
        int[][] nexts = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(mins[i], chrs.length);
        }
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            int tmp = chrs[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (j == tmp) {
                    for (int k = 0; k < 26; k++) {
                        sums[j][k]++;
                        res = Math.max(sums[j][k] - mins[j][k], res);
                    }
                } else {
                    mins[j][tmp] = Math.min(nexts[j][tmp], mins[j][tmp]);
                    sums[j][tmp]--;
                    nexts[j][tmp] = sums[j][tmp];
                    res = Math.max(sums[j][tmp] - mins[j][tmp], res);
                }
            }
        }
        return res;
    }
}

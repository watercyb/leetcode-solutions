/*
 * Problem: 2055. Plates Between Candles
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/plates-between-candles/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chrs = s.toCharArray();
        int[] sumsFromRight = new int[chrs.length];
        Arrays.fill(sumsFromRight, -1);
        int[] sumsFromLeft = new int[chrs.length];
        int sum = 0;
        int prv = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '*') {
                sum++;
                sumsFromLeft[i] = prv;
            } else {
                sumsFromRight[i] = sum;
                sumsFromLeft[i] = sum;
                prv = sumsFromLeft[i];
            }
        }
        sumsFromRight[chrs.length - 1] = sum;
        for (int i = chrs.length - 2; i >= 0; i--) {
            if (sumsFromRight[i] == -1)
                sumsFromRight[i] = sumsFromRight[i + 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = Math.max(sumsFromLeft[queries[i][1]] - sumsFromRight[queries[i][0]], 0);
        }
        return res;
    }
}

/*
 * Problem: 2222. Number of Ways to Select Buildings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-select-buildings/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long numberOfWays(String s) {
        char[] chrs = s.toCharArray();
        long res = 0;
        int zero = 0;
        long zeroOne = 0;
        int one = 0;
        long oneZero = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '1') {
                res += oneZero;
                one++;
                zeroOne += zero;
            } else {
                res += zeroOne;
                zero++;
                oneZero += one;
            }
        }
        return res;
    }
}

/*
 * Problem: 3463. Check If Digits Are Equal in String After Operations II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {

    public boolean hasSameDigits(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length - 2;
        long diff = 0;
        for (int i = 0; i <= n; i++) {
            diff += Lucas5(n, i) * (chrs[i] - chrs[i + 1]);
        }
        if (diff % 5 != 0)
            return false;
        diff = 0;
        for (int i = 0; i <= n; i++) {
            diff += Lucas2(n, i) * (chrs[i] - chrs[i + 1]);
        }
        return diff % 2 == 0;
    }

    public int Lucas5(int a, int b) {
        int res = 1;
        while (b > 0) {
            if (C[a % 5][b % 5] == 0)
                return 0;
            res = res * C[a % 5][b % 5];
            a /= 5;
            b /= 5;
        }
        return res % 5;
    }

    public int Lucas2(int a, int b) {
        int res = 1;
        while (b > 0) {
            if (C[a & 1][b & 1] == 0)
                return 0;
            res = res * C[a & 1][b & 1];
            a /= 2;
            b /= 2;
        }
        return res & 1;
    }

    int[][] C = { { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 2, 1, 0, 0 }, { 1, 3, 3, 1, 0 }, { 1, 4, 6, 4, 1 } };
}

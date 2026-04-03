/*
 * Problem: 471. Encode String with Shortest Length
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/encode-string-with-shortest-length/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {

    public String encode(String s) {
        int n = s.length();
        if (n <= 4)
            return s;
        String[][] DP = new String[n][n];
        for (int i = 0; i < n; i++) {
            DP[i][i] = s.substring(i, i + 1);
            for (int j = i - 1; j >= 0; j--) {
                if (i - j <= 3) {
                    DP[j][i] = s.substring(j, i + 1);
                    continue;
                }
                String str = s.substring(j, i + 1);
                int len = getLen1(str);
                if (len > 0) {
                    DP[j][i] = new StringBuilder().append(str.length() / len).append('[').append(DP[j][j + len - 1])
                            .append(']').toString();
                } else {
                    for (int k = j; k < i; k++) {
                        if (DP[j][k].length() + DP[k + 1][i].length() < str.length())
                            str = new StringBuilder(DP[j][k]).append(DP[k + 1][i]).toString();
                    }
                    DP[j][i] = str;
                }
            }
        }
        return DP[0][DP.length - 1];
    }

    public int getLen(String str) {
        int idx = new StringBuilder(str).append(str).toString().indexOf(str, 1);
        if (idx < str.length())
            return idx;
        return -1;
    }

    public int getLen1(String str) {
        char[] chrs = str.toCharArray();
        for (int l = 1; l <= chrs.length / 2; l++) {
            if (chrs.length % l == 0 && chk(chrs, l)) {
                return l;
            }
        }
        return -1;
    }

    public boolean chk(char[] chrs, int len) {
        for (int i = len; i < chrs.length; i++) {
            if (chrs[i] != chrs[i % len])
                return false;
        }
        return true;
    }
}

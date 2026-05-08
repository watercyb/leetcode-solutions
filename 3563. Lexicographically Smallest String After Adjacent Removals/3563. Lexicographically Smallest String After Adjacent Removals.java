/*
 * Problem: 3563. Lexicographically Smallest String After Adjacent Removals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-adjacent-removals/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public String lexicographicallySmallestString(String s) {
        char[] chrs = s.toCharArray();
        boolean[][] removable = getDP(chrs);
        if (removable[0][chrs.length - 1])
            return "";
        String[] DP = new String[chrs.length + 1];
        DP[chrs.length] = "";
        String res = "{";
        for (int i = chrs.length - 1; i >= 0; i--) {
            DP[i] = DP[i + 1];
            for (int j = i + 3; j <= chrs.length; j += 2) {
                if (removable[i + 1][j - 1] && DP[j].compareTo(DP[i]) < 0)
                    DP[i] = DP[j];
            }
            DP[i] = new StringBuilder(String.valueOf(chrs[i])).append(DP[i]).toString();
            if (i > 0 && removable[0][i - 1] && DP[i].compareTo(res) < 0)
                res = DP[i];
        }
        if (DP[0].compareTo(res) < 0)
            return DP[0];
        return res;
    }

    public boolean[][] getDP(char[] chrs) {
        boolean[][] res = new boolean[chrs.length][chrs.length];
        for (int i = 1; i < res.length; i++) {
            if (chk(chrs[i], chrs[i - 1]))
                res[i - 1][i] = true;
            for (int j = i - 3; j >= 0; j -= 2) {
                if (chk(chrs[i], chrs[j]) && res[j + 1][i - 1]) {
                    res[j][i] = true;
                } else {
                    for (int k = j + 1; k < i - 1; k += 2) {
                        if (res[j][k] && res[k + 1][i]) {
                            res[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean chk(char a, char b) {
        return Math.abs(a - b) % 24 == 1;
    }
}

/*
 * Problem: 2060. Check if an Original String Exists Given Two Encoded Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        char[] chrs1 = s1.toCharArray();
        char[] chrs2 = s2.toCharArray();
        return dfs(new boolean[chrs1.length + 1][chrs2.length + 1][2000], chrs1, chrs2, 0, 0, 0);
    }

    public boolean dfs(boolean[][][] seens, char[] chrs1, char[] chrs2, int i, int j, int diff) {
        if (i > chrs1.length || j > chrs2.length)
            return false;
        if (i == chrs1.length && j == chrs2.length)
            return diff == 0;
        if (seens[i][j][diff + 1000])
            return false;
        seens[i][j][diff + 1000] = true;
        char a = i < chrs1.length ? chrs1[i] : '@';
        char b = j < chrs2.length ? chrs2[j] : '@';
        if (Character.isDigit(a)) {
            int num = 0;
            while (i < chrs1.length && Character.isDigit(chrs1[i])) {
                num *= 10;
                num += chrs1[i] - '0';
                if (dfs(seens, chrs1, chrs2, i + 1, j, diff + num))
                    return true;
                i++;
            }
        } else if (Character.isDigit(b)) {
            int num = 0;
            while (j < chrs2.length && Character.isDigit(chrs2[j])) {
                num *= 10;
                num += chrs2[j] - '0';
                if (dfs(seens, chrs1, chrs2, i, j + 1, diff - num))
                    return true;
                j++;
            }
        } else {
            if (diff > 0)
                return dfs(seens, chrs1, chrs2, i, j + 1, diff - 1);
            if (diff < 0)
                return dfs(seens, chrs1, chrs2, i + 1, j, diff + 1);
            if (diff == 0 && a == b)
                return dfs(seens, chrs1, chrs2, i + 1, j + 1, diff);
        }
        return false;
    }
}

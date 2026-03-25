/*
 * Problem: 97. Interleaving String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/interleaving-string/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        return dfs(new boolean[s1.length() + 1][s2.length() + 1], s1.toCharArray(), s2.toCharArray(),
                s3.toCharArray(), 0, 0);
    }

    public boolean dfs(boolean[][] mems, char[] chrs1, char[] chrs2, char[] chrs3, int i, int j) {
        if (i == chrs1.length && j == chrs2.length)
            return true;
        if (mems[i][j])
            return false;
        mems[i][j] = true;
        int k = i + j;
        if (i < chrs1.length && chrs1[i] == chrs3[k] && dfs(mems, chrs1, chrs2, chrs3, i + 1, j))
            return true;
        if (j < chrs2.length && chrs2[j] == chrs3[k] && dfs(mems, chrs1, chrs2, chrs3, i, j + 1))
            return true;
        return false;
    }
}

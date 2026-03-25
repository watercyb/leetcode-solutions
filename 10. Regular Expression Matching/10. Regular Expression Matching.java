/*
 * Problem: 10. Regular Expression Matching
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/regular-expression-matching/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isMatch(String s, String p) {
        char[] chrS = s.toCharArray();
        char[] chrP = p.toCharArray();
        Boolean[][] mems = new Boolean[chrS.length][chrP.length];
        return dfs(mems, chrS, chrP, 0, 0);
    }

    public boolean dfs(Boolean[][] mems, char[] chrS, char[] chrP, int i, int j) {
        if (i == chrS.length && j == chrP.length)
            return true;
        if (j == chrP.length)
            return false;
        if (i == chrS.length) {
            while (j < chrP.length) {
                if (chrP[j] != '*' && (j == chrP.length - 1 || chrP[j + 1] != '*'))
                    return false;
                j++;
            }
            if (j == chrP.length)
                return true;
        }
        if (mems[i][j] != null)
            return mems[i][j];
        if (chrP[j] == '*') {
            mems[i][j] = dfs(mems, chrS, chrP, i, j + 1);
            return mems[i][j];
        } else if (chrS[i] == chrP[j] || chrP[j] == '.') {
            if (j < chrP.length - 1 && chrP[j + 1] == '*') {
                int k = i;
                while (k < chrS.length && (chrS[k] == chrP[j] || chrP[j] == '.')) {
                    mems[i][j] = dfs(mems, chrS, chrP, k + 1, j + 2);
                    if (mems[i][j])
                        return mems[i][j];
                    k++;
                }
                mems[i][j] = dfs(mems, chrS, chrP, i, j + 2);
                return mems[i][j];
            } else {
                mems[i][j] = dfs(mems, chrS, chrP, i + 1, j + 1);
                return mems[i][j];
            }
        } else if (chrS[i] != chrP[j] && j < chrP.length - 1 && chrP[j + 1] == '*') {
            mems[i][j] = dfs(mems, chrS, chrP, i, j + 2);
            return mems[i][j];
        }
        mems[i][j] = false;
        return mems[i][j];
    }
}

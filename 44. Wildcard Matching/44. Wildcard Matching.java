/*
 * Problem: 44. Wildcard Matching
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/wildcard-matching/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public boolean isMatch(String s, String p) {
        char[] chrS = s.toCharArray();
        char[] chrP = p.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chrS.length && j < chrP.length && chrP[j] != '*' && chrP[j] != '?') {
            if (chrS[i] != chrP[j])
                return false;
            i++;
            j++;
        }
        i = chrS.length - 1;
        j = chrP.length - 1;
        while (i >= 0 && j >= 0 && chrP[j] != '*' && chrP[j] != '?') {
            if (chrS[i] != chrP[j])
                return false;
            i--;
            j--;
        }
        boolean[][] mems = new boolean[chrS.length + 1][chrP.length + 1];
        return (dfs(mems, chrS, chrP, 0, 0));
    }

    public boolean dfs(boolean[][] mems, char[] chrS, char[] chrP, int i, int j) {
        if (mems[i][j] == true)
            return false;
        while (i < chrS.length && j < chrP.length && (chrS[i] == chrP[j] || chrP[j] == '?')) {
            i++;
            j++;
        }
        if (i == chrS.length && j == chrP.length) {
            return true;
        } else if (j == chrP.length) {
            return false;
        } else if (i == chrS.length) {
            while (j < chrP.length && chrP[j] == '*')
                j++;
            if (j == chrP.length) {
                return true;
            } else {
                return false;
            }
        } else if (chrP[j] != '*') {
            return false;
        } else {
            if (dfs(mems, chrS, chrP, i+1, j))
                    return true;
            if (dfs(mems, chrS, chrP, i, j + 1))
                    return true;
        }
        mems[i][j] = true;
        return false;
    }
}

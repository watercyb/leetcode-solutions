/*
 * Problem: 2573. Find the String with LCP
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-string-with-lcp/?envType=daily-question&envId=2026-03-28
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public String findTheString(int[][] lcp) {
        char[] chrs = new char[lcp.length];
        char chr = 'a';
        for (int i = 0; i < lcp.length; i++) {
            if (lcp[i][i] != lcp.length - i)
                return "";
            if (chrs[i] == 0) {
                if (chr == '{')
                    return "";
                chrs[i] = chr++;
            }
            for (int j = i + 1; j < lcp.length; j++) {
                if (lcp[i][j] != lcp[j][i])
                    return "";
                if (lcp[i][j] >= 1) {
                    if (chrs[j] != 0 && chrs[j] != chrs[i])
                        return "";
                    chrs[j] = chrs[i];
                }
            }
        }
        for (int i = lcp.length - 2; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (chrs[i] == chrs[j] && lcp[i][j] != 1 + lcp[i + 1][j + 1])
                    return "";
            }
        }
        for (int i = lcp.length - 1; i >= lcp.length - 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (chrs[i] == chrs[j] && lcp[i][j] != 1)
                    return "";
            }
        }
        return new String(chrs);
    }
}

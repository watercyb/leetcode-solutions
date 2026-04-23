/*
 * Problem: 2014. Longest Subsequence Repeated k Times
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-subsequence-repeated-k-times/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        chrs = s.toCharArray();
        int[] counts = new int['z' + 1];
        for (char chr : chrs) {
            counts[chr]++;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            counts[i] /= k;
        }
        dfs(new StringBuilder(), counts, k);
        return res;
    }

    int max = 0;
    String res = "";
    char[] chrs;

    public boolean chk(StringBuilder SB, int k) {
        if (SB.length() == 0)
            return true;
        int j = 0;
        for (int i = 0; i < chrs.length && k > 0; i++) {
            if (chrs[i] == SB.charAt(j)) {
                j++;
                if (j == SB.length()) {
                    j = 0;
                    k--;
                }
            }
        }
        return k == 0;
    }

    public void dfs(StringBuilder SB, int[] counts, int k) {
        if (chk(SB, k)) {
            if (SB.length() > res.length())
                res = SB.toString();
        } else {
            return;
        }
        for (char i = 'z'; i >= 'a'; i--) {
            if (counts[i] > 0) {
                counts[i]--;
                SB.append(i);
                dfs(SB, counts, k);
                counts[i]++;
                SB.setLength(SB.length() - 1);
            }
        }
    }
}

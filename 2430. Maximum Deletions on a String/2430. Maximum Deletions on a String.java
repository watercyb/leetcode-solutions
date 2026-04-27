/*
 * Problem: 2430. Maximum Deletions on a String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-deletions-on-a-string/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int deleteString(String s) {
        return dfs(s.toCharArray(), new int[s.length()], 0);
    }

    public int dfs(char[] chrs, int[] meme, int i) {
        if (i == chrs.length)
            return 0;
        if (meme[i] != 0)
            return meme[i];
        List<Integer> list = LPS(chrs, i);
        int res = 0;
        for (int next : list) {
            res = Math.max(dfs(chrs, meme, next), res);
        }
        return meme[i] = res + 1;
    }

    public List<Integer> LPS(char[] chrs, int n) {
        int[] lps = new int[chrs.length];
        lps[n] = n;
        int len = n;
        int idx = 1 + n;
        List<Integer> res = new ArrayList<>();
        while (idx < chrs.length) {
            if (chrs[idx] == chrs[len]) {
                len++;
                if (2 * len - n == idx + 1) {
                    res.add((idx + n + 1) / 2);
                }
                lps[idx++] = len;
            } else {
                if (len > n) {
                    len = lps[len - 1];
                } else {
                    len = n;
                    idx++;
                }
            }
        }
        return res;
    }
}

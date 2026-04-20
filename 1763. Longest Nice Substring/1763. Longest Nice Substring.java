/*
 * Problem: 1763. Longest Nice Substring
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-nice-substring/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public String longestNiceSubstring(String s) {
        dfs(s);
        return res;
    }

    String res = "";

    public void dfs(String s) {
        if (s.length() == 0)
            return;
        boolean[] seen = new boolean['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            seen[s.charAt(i)] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) < 'a' && !seen[s.charAt(i) + 32]) || (s.charAt(i) >= 'a' && !seen[s.charAt(i) - 32])) {
                dfs(s.substring(0, i));
                dfs(s.substring(i + 1, s.length()));
                return;
            }
        }
        if (s.length() > res.length())
            res = s;
    }
}

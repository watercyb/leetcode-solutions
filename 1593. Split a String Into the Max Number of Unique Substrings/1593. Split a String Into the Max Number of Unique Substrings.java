/*
 * Problem: 1593. Split a String Into the Max Number of Unique Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int maxUniqueSplit(String s) {
        dfs(s, new HashSet<>(), 0, 0);
        return res;
    }

    int res = 0;

    public void dfs(String s, HashSet<String> HS, int i, int n) {
        if (n + s.length() - i <= res)
            return;
        if (i == s.length()) {
            res = Math.max(n, res);
            return;
        }
        for (int j = i + 1; j <= s.length(); j++) {
            String k = s.substring(i, j);
            if (HS.add(k)) {
                dfs(s, HS, j, n + 1);
                HS.remove(k);
            }
        }
    }
}

/*
 * Problem: 2375. Construct Smallest Number From DI String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-smallest-number-from-di-string/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String smallestNumber(String pattern) {
        char[] chrs = pattern.toCharArray();
        for (int i = 1; i <= chrs.length + 1; i++) {
            if (dfs(chrs, new boolean[chrs.length + 2], 0, i))
                return String.valueOf(res);
        }
        return "";
    }

    int res = Integer.MAX_VALUE;

    public boolean dfs(char[] pattern, boolean[] used, int i, int num) {
        if (i == pattern.length) {
            res = num;
            return true;
        } else {
            int last = num % 10;
            used[last] = true;
            int lim = num % 10;
            if (pattern[i] == 'D') {
                for (int j = 1; j < lim; j++) {
                    if (!used[j] && dfs(pattern, used, i + 1, num * 10 + j)) {
                        return true;
                    }
                }
            } else {
                for (int j = lim + 1; j < used.length; j++) {
                    if (!used[j] && dfs(pattern, used, i + 1, num * 10 + j))
                        return true;
                }
            }
            used[last] = false;
        }
        return false;
    }
}

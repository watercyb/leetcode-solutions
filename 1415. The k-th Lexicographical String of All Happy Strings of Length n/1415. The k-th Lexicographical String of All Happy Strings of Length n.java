/*
 * Problem: 1415. The k-th Lexicographical String of All Happy Strings of Length n
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String getHappyString(int n, int k) {
        this.k = k;
        dfs(new char[n + 1], 1);
        return res;
    }

    String res = "";
    int k;

    public boolean dfs(char[] chrs, int i) {
        if (i == chrs.length) {
            if (--k == 0) {
                res = new String(chrs, 1, chrs.length - 1);
                return true;
            }
            return false;
        }
        for (char j = 'a'; j <= 'c'; j++) {
            if (j == chrs[i - 1])
                continue;
            chrs[i] = j;
            if (dfs(chrs, i + 1))
                return true;
        }
        return false;
    }
}

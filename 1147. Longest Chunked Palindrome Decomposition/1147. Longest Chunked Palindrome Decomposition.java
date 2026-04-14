/*
 * Problem: 1147. Longest Chunked Palindrome Decomposition
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int longestDecomposition(String text) {
        char[] chrs = text.toCharArray();
        return dfs(chrs, 0, chrs.length - 1);
    }

    int mod = 1_000_000_007;

    public int dfs(char[] chrs, int l1, int r2) {
        if (l1 > r2) {
            return 0;
        } else {
            int res = 1;
            int r1 = l1;
            int l2 = r2;
            long h1 = 0;
            long h2 = 0;
            long base = 1;
            while (r1 < l2) {
                h1 = (h1 * 26 + chrs[r1] - 'a') % mod;
                h2 = (h2 + (chrs[l2] - 'a') * base) % mod;
                base = (base * 26) % mod;
                r1++;
                l2--;
                if (h1 == h2) {
                    res = Math.max(dfs(chrs, r1, l2) + 2, res);
                    break;
                }
            }
            return res;
        }
    }
}

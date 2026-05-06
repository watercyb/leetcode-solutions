/*
 * Problem: 3327. Check if DFS Strings Are Palindromes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-if-dfs-strings-are-palindromes/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean[] findAnswer(int[] parent, String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[parent.length];
        for (int i = 1; i < parent.length; i++) {
            counts[parent[i]]++;
        }
        int[][] links = new int[parent.length][];
        for (int i = 0; i < parent.length; i++) {
            links[i] = new int[counts[i]];
        }
        for (int i = parent.length - 1; i >= 1; i--) {
            links[parent[i]][--counts[parent[i]]] = i;
        }
        boolean[] res = new boolean[links.length];
        dfs(links, res, chrs, 0);
        return res;
    }

    int mod = 1_000_000_007;

    public long[] dfs(int[][] links, boolean[] res, char[] chrs, int i) {
        long h = 0;
        long base = 1;
        long h1 = 0;
        for (int next : links[i]) {
            long[] nextRes = dfs(links, res, chrs, next);
            h = (h + nextRes[0] * base) % mod;
            base = (base * nextRes[2]) % mod;
            h1 = (h1 * nextRes[2] + nextRes[1]) % mod;
        }
        h = (h + (chrs[i] - 'a') * base) % mod;
        base = (base * 26) % mod;
        h1 = (h1 * 26 + chrs[i] - 'a') % mod;
        res[i] = h == h1;
        return new long[] { h, h1, base };
    }
}

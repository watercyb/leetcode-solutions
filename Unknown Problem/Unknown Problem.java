/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-reverse-ii/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String lexSmallest(String s) {
        char[] chrs = s.toCharArray();
        prefixes = new int[chrs.length];
        suffixes = new int[chrs.length];
        suffixe_revs = new int[chrs.length];
        bases = new int[chrs.length];
        long h = 0;
        long h_rev = 0;
        long base = 1;
        for (int i = 0; i < chrs.length; i++) {
            bases[i] = (int) base;
            h = (h * 26 + chrs[i] - 'a') % mod;
            prefixes[i] = (int) h;
            base = base * 26 % mod;
        }
        h = 0;
        for (int i = chrs.length - 1; i >= 0; i--) {
            h = (h * 26 + chrs[i] - 'a') % mod;
            h_rev = (h_rev + (chrs[i] - 'a') * bases[chrs.length - 1 - i]) % mod;
            suffixes[i] = (int) h;
            suffixe_revs[i] = (int) h_rev;
        }
        int max_type = 0;
        int max_idx = chrs.length - 1;
        for (int i = 0; i < chrs.length - 1; i++) {
            if (compare(chrs, max_type, max_idx, 0, i)) {
                max_idx = i;
            }
        }
        for (int i = chrs.length - 2; i >= 1; i--) {
            if (compare(chrs, max_type, max_idx, 1, i)) {
                max_type = 1;
                max_idx = i;
            }
        }
        if (max_type == 0) {
            return new StringBuilder(s.substring(0, max_idx))
                    .append(new StringBuilder(s.substring(max_idx)).reverse().toString()).toString();
        } else {
            return new StringBuilder(s.substring(0, max_idx + 1)).reverse()
                    .append(s.substring(max_idx + 1)).toString();
        }
    }

    int mod = 1_000_000_007;
    int[] prefixes;
    int[] suffixes;
    int[] suffixe_revs;
    int[] bases;

    public int getH(int type, int i, int len) {
        if (type == 0) {
            if (len <= i)
                return prefixes[len - 1];
            long res = i == 0 ? 0 : ((long) prefixes[i - 1] * bases[len - i] % mod + mod) % mod;
            res = (res + suffixes[suffixes.length - (len - i)]) % mod;
            return (int) res;
        } else {
            if (len <= i + 1) {
                long res = ((long) suffixes[i + 1 - len] - (long) suffixes[i + 1] * bases[len] % mod + mod) % mod;
                return (int) res;
            }
            long res = ((long) suffixes[0] - (long) suffixes[i + 1] * bases[i + 1] % mod + mod) % mod;
            res = (res * bases[suffixes.length - 1 - i] + suffixe_revs[i + 1]) % mod;
            return (int) res;
        }
    }

    public boolean compare(char[] chrs, int type1, int i, int type2, int j) {
        int l = 1;
        int r = chrs.length + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int h1 = getH(type1, i, mid);
            int h2 = getH(type2, j, mid);
            if (h1 != h2) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == chrs.length + 1)
            return false;
        return getChr(chrs, type2, j, l) < getChr(chrs, type1, i, l);
    }

    public char getChr(char[] chrs, int type, int i, int len) {
        if (type == 0) {
            if (len <= i)
                return chrs[len - 1];
            return chrs[chrs.length - (len - i)];
        } else {
            if (len <= i + 1)
                return chrs[i + 1 - len];
            return chrs[len - 1];
        }
    }
}

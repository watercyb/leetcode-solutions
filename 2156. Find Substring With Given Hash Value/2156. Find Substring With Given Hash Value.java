/*
 * Problem: 2156. Find Substring With Given Hash Value
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-substring-with-given-hash-value/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        char[] chrs = s.toCharArray();
        long h = 0;
        long base = 1;
        for (int i = chrs.length - 1; i > chrs.length - k; i--) {
            h = (h * power + (chrs[i] & 31)) % modulo;
            base = base * power % modulo;
        }
        h = (h * power + (chrs[chrs.length - k] & 31)) % modulo;
        int res = 0;
        if (h == hashValue)
            res = chrs.length - k;
        for (int i = chrs.length - k - 1; i >= 0; i--) {
            h = (((h - (chrs[i + k] & 31) * base) % modulo + modulo) * power + (chrs[i] & 31)) % modulo;
            if (h == hashValue)
                res = i;
        }
        return s.substring(res, res + k);
    }
}

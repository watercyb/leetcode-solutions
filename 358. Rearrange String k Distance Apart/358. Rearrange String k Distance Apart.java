/*
 * Problem: 358. Rearrange String k Distance Apart
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0)
            return s;
        char[] chrs = s.toCharArray();
        int n = chrs.length / k;
        int base = n * k;
        char[] res = new char[chrs.length];
        int[] counts = new int['z' + 1];
        int countSizeN1 = chrs.length - n * k;
        for (int i = 0; i < chrs.length; i++) {
            counts[chrs[i]]++;
            if ((counts[chrs[i]] == n + 1 && countSizeN1-- == 0) || counts[chrs[i]] == n + 2)
                return "";
        }
        int idx = base == chrs.length ? base - k : base;
        for (char i = 'a'; i <= 'z'; i++) {
            if (counts[i] > n) {
                while (counts[i] > 0) {
                    res[idx] = i;
                    counts[i]--;
                    idx -= k;
                    if (idx < 0) {
                        idx += k + 1 + base;
                        if (idx >= chrs.length)
                            idx -= k;
                    }
                }
            }
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (counts[i] <= n) {
                while (counts[i] > 0) {
                    res[idx] = i;
                    counts[i]--;
                    idx -= k;
                    if (idx < 0) {
                        idx = idx + k + 1 + n * k;
                        if (idx >= chrs.length)
                            idx -= k;
                    }
                }
            }
        }
        return new String(res);
    }
}

/*
 * Problem: 1316. Distinct Echo Substrings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distinct-echo-substrings/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int distinctEchoSubstrings(String text) {
        long mod = 1_000_000_000_007l;
        char[] chrs = text.toCharArray();
        int res = 0;
        long[] h = new long[chrs.length];
        HashSet<Long> HS = new HashSet<>();
        for (int i = 1; i <= chrs.length / 2; i++) {
            HS.clear();
            for (int j = i - 1; j < chrs.length; j++) {
                int idx = j - i + 1;
                h[idx] = (h[idx] * 26 + chrs[j] - 'a') % mod;
                if (idx - i >= 0 && h[idx] == h[idx - i] && HS.add(h[idx]))
                    res++;
            }
        }
        return res;
    }
}

/*
 * Problem: 2168. Unique Substrings With Equal Digit Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/unique-substrings-with-equal-digit-frequency/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int equalDigitFrequency(String s) {
        int mod = 1_000_000_007;
        char[] chrs = s.toCharArray();
        int res = 0;
        HashSet<Long>[] HS = new HashSet[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            HS[i] = new HashSet<>();
        }
        for (int i = 0; i < chrs.length; i++) {
            long h = 0;
            int[] counts = new int[10];
            int max = 0;
            int count = 0;
            for (int j = i; j < chrs.length; j++) {
                int digit = chrs[j] - '0';
                h = (h * 10 + digit) % mod;
                counts[digit]++;
                if (counts[digit] > max) {
                    max = counts[digit];
                    count = 1;
                } else if (counts[digit] == max) {
                    count++;
                }
                if (max * count == j - i + 1 && HS[j - i].add(h))
                    res++;
            }
        }
        return res;
    }
}

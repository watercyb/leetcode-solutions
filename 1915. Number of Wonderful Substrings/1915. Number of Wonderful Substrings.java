/*
 * Problem: 1915. Number of Wonderful Substrings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-wonderful-substrings/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public long wonderfulSubstrings(String word) {
        long[] counts = new long[1024];
        counts[0] = 1;
        int tmp = 0;
        long res = 0;
        for (char chr : word.toCharArray()) {
            tmp ^= 1 << (chr - 'a');
            counts[tmp]++;
        }
        for (int i = 0; i < counts.length; i++) {
            res += counts[i] * (counts[i] - 1) / 2;
            for (int j = 1; j <= i; j <<= 1) {
                if ((i & j) == j)
                    res += counts[i] * counts[i - j];
            }
        }
        return res;
    }
}

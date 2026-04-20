/*
 * Problem: 1758. Minimum Changes To Make Alternating Binary String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minOperations(String s) {
        char[] chrs=s.toCharArray();
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            res += (i & 1) ^ (chrs[i]- '0');
        }
        if (res > chrs.length / 2)
            return chrs.length - res;
        return res;

    }
}

/*
 * Problem: 91. Decode Ways
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decode-ways/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int numDecodings(String s) {
        char[] chrs = s.toCharArray();
        if (chrs[0] == '0')
            return 0;
        if (chrs.length == 1)
            return 1;
        int[] DP = new int[chrs.length + 1];
        DP[0] = 1;
        DP[1] = 1;
        for (int i = 1; i < chrs.length; i++) {
            if (chrs[i] != '0')
                DP[i + 1] = DP[i];
            if ((chrs[i - 1] == '2' && chrs[i] <= '6') || chrs[i - 1] == '1')
                DP[i + 1] += DP[i - 1];
        }
        return DP[chrs.length];
    }
}


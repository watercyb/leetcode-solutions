/*
 * Problem: 639. Decode Ways II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/decode-ways-ii/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int numDecodings(String s) {
        int mod = 1_000_000_007;
        char[] chrs = s.toCharArray();
        if (chrs[0] == '0')
            return 0;
        long DPFirst = 1;
        long DPSecond = 1;
        if (chrs[0] == '*')
            DPSecond = 9;
        for (int i = 1; i < chrs.length; i++) {
            long next = 0;
            if (chrs[i] == '*' && chrs[i - 1] == '*') {
                next = 9 * DPSecond + 15 * DPFirst;
            } else if (chrs[i] == '*') {
                next = 9 * DPSecond;
                if (chrs[i - 1] == '1') {
                    next += 9 * DPFirst;
                } else if (chrs[i - 1] == '2') {
                    next += 6 * DPFirst;
                }
            } else if (chrs[i - 1] == '*') {
                if (chrs[i] != '0')
                    next = DPSecond;
                if (chrs[i] <= '6') {
                    next += 2 * DPFirst;
                } else {
                    next += DPFirst;
                }
            } else {
                if (chrs[i] != '0')
                    next = DPSecond;
                int sum = (chrs[i - 1] - '0') * 10 + chrs[i] - '0';
                if (sum >= 10 && sum <= 26)
                    next += DPFirst;
            }
            if (next == 0)
                return 0;
            DPFirst = DPSecond;
            DPSecond = next % mod;
        }
        return (int) DPSecond;
    }
}

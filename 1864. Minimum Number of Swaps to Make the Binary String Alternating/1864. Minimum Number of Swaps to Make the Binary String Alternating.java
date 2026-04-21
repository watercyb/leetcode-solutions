/*
 * Problem: 1864. Minimum Number of Swaps to Make the Binary String Alternating
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minSwaps(String s) {
        char[] chrs = s.toCharArray();
        int sum = 0;
        for (char chr : chrs) {
            sum += chr - '0';
        }
        if (sum != (chrs.length + 1) / 2 && sum != chrs.length / 2)
            return -1;
        if (chrs.length % 2 == 0) {
            int res = 0;
            for (int i = 0; i < chrs.length; i += 2) {
                if (chrs[i] != '1')
                    res++;
            }
            return Math.min(chrs.length / 2 - res, res);
        } else {
            if (sum == (chrs.length + 1) / 2) {
                int res = 0;
                for (int i = 0; i < chrs.length; i += 2) {
                    if (chrs[i] != '1')
                        res++;
                }
                return res;
            } else {
                int res = 0;
                for (int i = 0; i < chrs.length; i += 2) {
                    if (chrs[i] != '0')
                        res++;
                }
                return res;
            }
        }
    }
}

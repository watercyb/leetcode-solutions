/*
 * Problem: 1312. Minimum Insertion Steps to Make a String Palindrome
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minInsertions(String s) {
        char[] chrs = s.toCharArray();
        int[] DP = new int[chrs.length + 1];
        for (int i = 1; i < DP.length; i++) {
            DP[i] = i;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < DP.length - 1; i++) {
            int prv = DP[0];
            DP[0] = i + 1;
            for (int j = 0; j < DP.length - i - 2; j++) {
                if (chrs[i] != chrs[chrs.length - 1 - j]) {
                    prv = DP[j + 1];
                    DP[j + 1] = Math.min(DP[j + 1], DP[j]) + 1;
                } else {
                    int tmp = DP[j + 1];
                    DP[j + 1] = prv;
                    prv = tmp;
                }
            }
            res = Math.min(Math.min(DP[DP.length - i - 2], prv), res);
        }
        return res;
    }
}

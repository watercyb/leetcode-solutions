/*
 * Problem: 1216. Valid Palindrome III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/valid-palindrome-iii/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public boolean isValidPalindrome(String s, int k) {
        char[] chrs = s.toCharArray();
        int[][] mems = new int[chrs.length][chrs.length];
        for (int i = 1; i < chrs.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (chrs[i] == chrs[j]) {
                    mems[j][i] = mems[j + 1][i - 1];
                } else {
                    mems[j][i] = Math.min(mems[j + 1][i], mems[j][i - 1]) + 1;
                }
            }
        }
        return mems[0][chrs.length - 1] <= k;
    }
}

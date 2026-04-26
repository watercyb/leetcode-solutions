/*
 * Problem: 2384. Largest Palindromic Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-palindromic-number/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String largestPalindromic(String num) {
        int[] counts = new int['9' + 1];
        for (char chr : num.toCharArray()) {
            counts[chr]++;
        }
        StringBuilder SB = new StringBuilder();
        char odd = '@';
        for (char i = '9'; i > '0'; i--) {
            if (counts[i] % 2 == 1 && odd == '@')
                odd = i;
            for (int j = 0; j < counts[i] / 2; j++) {
                SB.append(i);
            }
        }
        if (SB.length() != 0) {
            if (counts['0'] % 2 == 1 && odd == '@')
                odd = '0';
            for (int j = 0; j < counts['0'] / 2; j++) {
                SB.append('0');
            }
        } else if (odd == '@') {
            return "0";
        }
        StringBuilder res = new StringBuilder(SB.toString());
        if (odd != '@')
            SB.append(odd);
        return res.append(SB.reverse()).toString();
    }
}

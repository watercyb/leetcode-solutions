/*
 * Problem: 415. Add Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/add-strings/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder SB = new StringBuilder();
        int carry = 0;
        char[] chrs1 = num1.toCharArray();
        char[] chrs2 = num2.toCharArray();
        int i = chrs1.length - 1;
        int j = chrs2.length - 1;
        while (i >= 0 && j >= 0) {
            int tmp = chrs1[i] + chrs2[j] + carry - '0' - '0';
            SB.append((char) (tmp % 10 + '0'));
            carry = tmp / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int tmp = chrs1[i] + carry - '0' ;
            SB.append((char) (tmp % 10 + '0'));
            carry = tmp / 10;
            i--;
        }
        while (j >= 0) {
            int tmp = chrs2[j] + carry - '0' ;
            SB.append((char) (tmp % 10 + '0'));
            carry = tmp / 10;
            j--;
        }
        if (carry!=0) SB.append((char) (carry+'0'));
        return SB.reverse().toString();
    }
}

/*
 * Problem: 2864. Maximum Odd Binary Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-odd-binary-number/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] chrs = s.toCharArray();
        int i = chrs.length - 1;
        int j = i;
        while (j >= 0) {
            if (chrs[j] == '1') {
                char tmp = chrs[j];
                chrs[j] = chrs[i];
                chrs[i] = tmp;
                j--;
                i = j;
                break;
            }
            j--;
        }
        while (j >= 0) {
            if (chrs[j] == '0') {
                char tmp = chrs[j];
                chrs[j] = chrs[i];
                chrs[i] = tmp;
                i--;
            }
            j--;
        }
        return new String(chrs);
    }
}

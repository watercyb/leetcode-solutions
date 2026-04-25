/*
 * Problem: 2259. Remove Digit From Number to Maximize Result
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public String removeDigit(String number, char digit) {
        char[] chrs = number.toCharArray();
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == digit) {
                if (i < chrs.length - 1 && chrs[i + 1] > digit)
                    return getStr(chrs, i);
                idx = i;
            }
        }
        return getStr(chrs, idx);
    }

    public String getStr(char[] chrs, int idx) {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < chrs.length; i++) {
            if (i != idx) {
                SB.append(chrs[i]);
            }
        }
        return SB.toString();
    }
}

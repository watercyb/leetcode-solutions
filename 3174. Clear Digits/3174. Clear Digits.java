/*
 * Problem: 3174. Clear Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/clear-digits/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public String clearDigits(String s) {
        char[] chrs = s.toCharArray();
        int count = 0;
        StringBuilder SB = new StringBuilder();
        for (int i = chrs.length - 1; i >= 0; i--) {
            if (Character.isDigit(chrs[i])) {
                count++;
            } else {
                if (count == 0) {
                    SB.append(chrs[i]);
                } else {
                    count--;
                }
            }
        }
        return SB.reverse().toString();
    }
}

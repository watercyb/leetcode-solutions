/*
 * Problem: 482. License Key Formatting
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/license-key-formatting/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder SB = new StringBuilder();
        int diff='a' - 'A';
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char chr = s.charAt(i);
            if (chr == '-')
                continue;
            if (Character.isLowerCase(chr))
                chr -= diff;
            SB.append(chr);
            count++;
            if (count == k) {
                SB.append('-');
                count = 0;
            }
        }
        if (count == 0 && SB.length() > 0)
            SB.setLength(SB.length() - 1);
        return SB.reverse().toString();
    }
}

/*
 * Problem: 423. Reconstruct Original Digits from English
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String originalDigits(String s) {
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int[] digits = new int[10];
        digits[0] = counts['z'];
        digits[2] = counts['w'];
        digits[4] = counts['u'];
        digits[6] = counts['x'];
        digits[8] = counts['g'];
        digits[5] = counts['f'] - digits[4];
        digits[7] = counts['s'] - digits[6];
        digits[3] = counts['t'] - digits[2] - digits[8];
        digits[9] = counts['i'] - digits[5] - digits[6] - digits[8];
        digits[1] = counts['o'] - digits[0] - digits[2] - digits[4];
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digits[i]; j++) {
                SB.append((char) (i + '0'));
            }
        }
        return SB.toString();
    }
}


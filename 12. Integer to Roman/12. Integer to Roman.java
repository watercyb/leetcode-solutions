/*
 * Problem: 12. Integer to Roman
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/integer-to-roman/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String intToRoman(int num) {
        char[] RN = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        StringBuilder SB = new StringBuilder();
        int idx = 0;
        while (num > 0) {
            int tmp = num % 10;
            if (tmp <= 3) {
                for (int i = 0; i < tmp; i++) {
                    SB.append(RN[idx]);
                }
            } else if (tmp == 4) {
                SB.append(RN[idx + 1]);
                SB.append(RN[idx]);
            } else if (tmp < 9) {
                for (int i = 6; i <= tmp; i++) {
                    SB.append(RN[idx]);
                }
                SB.append(RN[idx + 1]);
            } else {
                SB.append(RN[idx + 2]);
                SB.append(RN[idx]);
            }
            num /= 10;
            idx += 2;
        }
        return SB.reverse().toString();
    }
}

/*
 * Problem: 405. Convert a Number to Hexadecimal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder SB = new StringBuilder();
        while (num != 0) {
            int digit = 0;
            for (int i = 0; i < 4; i++) {
                digit += (num & 1) << i;
                num >>>= 1;
            }
            if (digit < 10) {
                SB.append((char) (digit + '0'));
            } else {
                SB.append((char) (digit - 10 + 'a'));
            }
        }
        return SB.reverse().toString();
    }
}

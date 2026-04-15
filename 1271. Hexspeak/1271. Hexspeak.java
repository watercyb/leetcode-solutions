/*
 * Problem: 1271. Hexspeak
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/hexspeak/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String toHexspeak(String num) {
        StringBuilder SB = new StringBuilder();
        long n = Long.valueOf(num);
        while (n > 0) {
            long mod = n % 16;
            if (mod >= 10) {
                SB.append((char) (mod - 10 + 'A'));
            } else if (mod == 0) {
                SB.append('O');
            } else if (mod == 1) {
                SB.append('I');
            } else {
                return "ERROR";
            }
            n /= 16;
        }
        return SB.reverse().toString();
    }
}

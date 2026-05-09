/*
 * Problem: 3602. Hexadecimal and Hexatrigesimal Conversion
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/hexadecimal-and-hexatrigesimal-conversion/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public String concatHex36(int n) {
        int num = n * n * n;
        StringBuilder SB = new StringBuilder();
        while (num > 0) {
            int mod = num % 36;
            num /= 36;
            if (mod < 10) {
                SB.append(mod);
            } else {
                SB.append((char) (mod + 'A' - 10));
            }
        }
        num = n * n;
        while (num > 0) {
            int mod = num % 16;
            num /= 16;
            if (mod < 10) {
                SB.append(mod);
            } else {
                SB.append((char) (mod + 'A' - 10));
            }
        }
        return SB.reverse().toString();
    }
}

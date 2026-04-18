/*
 * Problem: 1556. Thousand Separator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/thousand-separator/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public String thousandSeparator(int n) {
        if (n == 0)
            return "0";
        StringBuilder SB = new StringBuilder();
        int count = 0;
        while (n > 0) {
            SB.append(n % 10);
            count++;
            if (count % 3 == 0 && n >= 10)
                SB.append('.');
            n /= 10;
        }
        return SB.reverse().toString();
    }
}

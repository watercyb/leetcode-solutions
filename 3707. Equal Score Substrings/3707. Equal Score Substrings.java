/*
 * Problem: 3707. Equal Score Substrings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/equal-score-substrings/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public boolean scoreBalance(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - 'a' + 1;
        }
        int sum1 = 0;
        for (int i = 0; sum1 < sum; i++) {
            sum1 += (s.charAt(i) - 'a' + 1) * 2;
        }
        return sum1 == sum;
    }
}

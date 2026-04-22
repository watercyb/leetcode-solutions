/*
 * Problem: 1963. Minimum Number of Swaps to Make the String Balanced
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minSwaps(String s) {
        int a = 0;
        int b = 0;
        for (char chr : s.toCharArray()) {
            if (chr == ']') {
                if (b == 0) {
                    a++;
                } else {
                    b--;
                }
            } else {
                b++;
            }
        }
        return (a + 1) / 2;
    }
}

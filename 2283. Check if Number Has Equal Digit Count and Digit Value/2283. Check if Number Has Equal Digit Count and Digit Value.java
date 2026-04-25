/*
 * Problem: 2283. Check if Number Has Equal Digit Count and Digit Value
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public boolean digitCount(String num) {
        int[] counts = new int[10];
        int[] target = new int[10];
        for (int i = 0; i < num.length(); i++) {
            counts[num.charAt(i) - '0']++;
            target[i] = num.charAt(i) - '0';
        }
        for (int i = 0; i <= 9; i++) {
            if (counts[i] != target[i])
                return false;
        }
        return true;
    }
}

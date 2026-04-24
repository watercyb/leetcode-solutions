/*
 * Problem: 2119. A Number After a Double Reversal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/a-number-after-a-double-reversal/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public boolean isSameAfterReversals(int num) {
        if (num>=10&&num%10==0) return false;
        return true;
    }
}

/*
 * Problem: 3675. Minimum Operations to Transform String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-transform-string/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minOperations(String s) {
        int min = 26;
        for (char chr : s.toCharArray()) {
            if (chr != 'a')
                min = Math.min(min, chr - 'a');
            if (min == 1)
                return 25;
        }
        return 26 - min;
    }
}

/*
 * Problem: 1513. Number of Substrings With Only 1s
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-substrings-with-only-1s/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {

    public int numSub(String s) {
        int count = 0;
        long res = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '1') {
                count++;
                res += count;
            } else {
                count = 0;
            }
        }
        return (int)(res%1_000_000)
    }
}


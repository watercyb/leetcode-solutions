/*
 * Problem: 1180. Count Substrings with Only One Distinct Letter
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int countLetters(String s) {
        char prv = '#';
        int count = 0;
        int res = 0;
        for (char chr : s.toCharArray()) {
            if (chr == prv) {
                count++;
            } else {
                prv = chr;
                count = 1;
            }
            res += count;
        }
        return res;
    }
}

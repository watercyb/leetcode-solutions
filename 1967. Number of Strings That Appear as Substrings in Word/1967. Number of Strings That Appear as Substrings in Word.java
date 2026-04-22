/*
 * Problem: 1967. Number of Strings That Appear as Substrings in Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for (String str : patterns) {
            if (word.indexOf(str) >= 0)
                res++;
        }
        return res;
    }
}

/*
 * Problem: 58. Length of Last Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/length-of-last-word/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.stripTrailing();
        int len = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ')
                return len;
            len++;
        }
        return len;
    }
}

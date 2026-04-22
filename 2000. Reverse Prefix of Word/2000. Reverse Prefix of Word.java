/*
 * Problem: 2000. Reverse Prefix of Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-prefix-of-word/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        return new StringBuilder(word.substring(0, idx + 1)).reverse()
                .append(word.subSequence(idx + 1, word.length())).toString();

    }
}

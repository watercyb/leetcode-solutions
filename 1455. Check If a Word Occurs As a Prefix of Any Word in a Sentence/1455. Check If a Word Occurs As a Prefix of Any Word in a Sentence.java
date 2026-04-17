/*
 * Problem: 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }
}

/*
 * Problem: 2490. Circular Sentence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/circular-sentence/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public boolean isCircularSentence(String sentence) {
        char[] chrs = sentence.toCharArray();
        if (chrs[0] != chrs[chrs.length - 1])
            return false;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == ' ' && chrs[i - 1] != chrs[i + 1])
                return false;
        }
        return true;
    }
}

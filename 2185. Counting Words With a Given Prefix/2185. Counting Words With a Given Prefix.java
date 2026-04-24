/*
 * Problem: 2185. Counting Words With a Given Prefix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref))
                res++;
        }
        return res;
    }
}

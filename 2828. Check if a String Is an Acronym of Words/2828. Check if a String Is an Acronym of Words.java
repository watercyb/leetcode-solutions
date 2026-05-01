/*
 * Problem: 2828. Check if a String Is an Acronym of Words
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size())
            return false;
        int idx = 0;
        for (char chr : s.toCharArray()) {
            if (words.get(idx++).charAt(0) != chr)
                return false;
        }
        return true;
    }
}

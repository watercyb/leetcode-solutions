/*
 * Problem: 2309. Greatest English Letter in Upper and Lower Case
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String greatestLetter(String s) {
        for (int i = 'Z'; i >= 'A'; i--) {
            if (s.contains(String.valueOf((char) i)) && s.contains(String.valueOf((char) (i - 'A' + 'a')))) {
                return String.valueOf((char) i);
            }
        }
        return "";
    }
}

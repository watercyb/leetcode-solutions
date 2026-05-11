/*
 * Problem: 3813. Vowel-Consonant Score
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/vowel-consonant-score/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0;
        int c = 0;
        for (char chr : s.toCharArray()) {
            if (!Character.isLetter(chr))
                continue;
            if (chr == 'a' || chr == 'e' || chr == 'i' || chr == 'o' || chr == 'u') {
                v += 1;
            } else {
                c += 1;
            }
        }
        if (c == 0)
            return 0;
        return v / c;
    }
}

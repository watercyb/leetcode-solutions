/*
 * Problem: 1309. Decrypt String from Alphabet to Integer Mapping
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder SB = new StringBuilder();
        int idx = s.length() - 1;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                SB.append((char) ((s.charAt(idx - 2) - '0') * 10 + s.charAt(idx - 1) - 1 - '0' + 'a'));
                idx -= 3;
            } else {
                SB.append((char) (s.charAt(idx) - 1 - '0' + 'a'));
                idx--;
            }
        }
        return SB.reverse().toString();
    }
}

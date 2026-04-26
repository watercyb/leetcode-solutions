/*
 * Problem: 2351. First Letter to Appear Twice
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/first-letter-to-appear-twice/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seens = new boolean['z' + 1];
        for (char chr : s.toCharArray()) {
            if (seens[chr])
                return chr;
            seens[chr] = true;
        }
        return '0';
    }
}

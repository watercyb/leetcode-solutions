/*
 * Problem: 3227. Vowels Game in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/vowels-game-in-a-string/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public boolean doesAliceWin(String s) {
        boolean[] isVowels = new boolean['z' + 1];
        isVowels['a'] = true;
        isVowels['e'] = true;
        isVowels['i'] = true;
        isVowels['o'] = true;
        isVowels['u'] = true;
        for (int i = 0; i < s.length(); i++) {
            if (isVowels[s.charAt(i)])
                return true;
        }
        return false;
    }
}

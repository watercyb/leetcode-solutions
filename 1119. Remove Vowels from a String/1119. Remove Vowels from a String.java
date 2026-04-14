/*
 * Problem: 1119. Remove Vowels from a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-vowels-from-a-string/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public String removeVowels(String s) {
        boolean[] isVowels = new boolean['z' + 1];
        isVowels['a'] = true;
        isVowels['e'] = true;
        isVowels['i'] = true;
        isVowels['o'] = true;
        isVowels['u'] = true;
        StringBuilder SB = new StringBuilder();
        for (char chr : s.toCharArray()) {
            if (!isVowels[chr])
                SB.append(chr);
        }
        return SB.toString();
    }
}

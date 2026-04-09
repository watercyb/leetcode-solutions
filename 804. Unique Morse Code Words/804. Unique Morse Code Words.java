/*
 * Problem: 804. Unique Morse Code Words
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/unique-morse-code-words/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> HS = new HashSet<>();
        for (String word : words) {
            insert(HS, word);
        }
        return HS.size();
    }

    String[] strs = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--.." };

    public void insert(HashSet<String> HS, String word) {
        StringBuilder SB = new StringBuilder();
        for (char chr : word.toCharArray()) {
            SB.append(strs[chr - 'a']);
        }
        HS.add(SB.toString());
    }
}

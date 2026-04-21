/*
 * Problem: 1859. Sorting the Sentence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sorting-the-sentence/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        String[] strs1 = new String[strs.length];
        for (String str : strs) {
            strs1[str.charAt(str.length() - 1) - '1'] = str.substring(0, str.length() - 1);
        }
        StringBuilder SB = new StringBuilder();
        for (String str : strs1) {
            SB.append(str).append(' ');
        }
        SB.setLength(SB.length() - 1);
        return SB.toString();
    }
}

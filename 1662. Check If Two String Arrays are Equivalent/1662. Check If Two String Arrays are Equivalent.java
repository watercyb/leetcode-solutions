/*
 * Problem: 1662. Check If Two String Arrays are Equivalent
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return cmb(word1).equals(cmb(word2));
    }

    public String cmb(String[] word) {
        StringBuilder SB=new StringBuilder();
        for (String str:word) {
            SB.append(str);
        }
        return SB.toString();
    }
}

/*
 * Problem: 1832. Check if the Sentence Is Pangram
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seens = new boolean['z' + 1];
        int count = 0;
        for (char chr : sentence.toCharArray()) {
            if (!seens[chr]) {
                seens[chr] = true;
                if (count++ == 25)
                    return true;
            }
        }
        return false;
    }
}

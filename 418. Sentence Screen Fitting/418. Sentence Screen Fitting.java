/*
 * Problem: 418. Sentence Screen Fitting
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sentence-screen-fitting/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder SB = new StringBuilder();
        for (String str : sentence) {
            if (str.length() > cols)
                return 0;
            SB.append(str);
            SB.append(" ");
        }
        int size = SB.length();
        int idx = 0;
        int res = 0;
        while (rows > 0) {
            idx = (idx + cols) % size;
            while (idx >= 0 && SB.charAt(idx) != ' ') {
                idx--;
                res--;
            }
            idx++;
            rows--;
            res += cols + 1;
        }
        return res / size;
    }
}

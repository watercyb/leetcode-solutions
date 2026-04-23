/*
 * Problem: 2075. Decode the Slanted Ciphertext
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decode-the-slanted-ciphertext/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        char[][] chrs = new char[rows][];
        int len = encodedText.length() / rows;
        for (int i = 0; i < rows; i++) {
            chrs[i] = encodedText.substring(i * len, i * len + len).toCharArray();
        }
        char[] chrs1 = new char[encodedText.length()];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < rows && i + j < len; j++) {
                chrs1[idx++] = chrs[j][i + j];
            }
        }
        idx--;
        while (idx >= 0 && chrs1[idx] == ' ') {
            idx--;
        }
        return new String(chrs1, 0, idx + 1);
    }
}

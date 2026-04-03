/*
 * Problem: 500. Keyboard Row
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/keyboard-row/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String[] findWords(String[] words) {
        int[] rows = new int['z' + 1];
        for (char chr : "qwertyuiopQWERTYUIOP".toCharArray()) {
            rows[chr] = 0;
        }
        for (char chr : "asdfghjklASDFGHJKL".toCharArray()) {
            rows[chr] = 1;
        }
        for (char chr : "zxcvbnmZXCVBNM".toCharArray()) {
            rows[chr] = 2;
        }
        int j = 0;
        for (int i = 0; i < words.length; i++) {
            int row = rows[words[i].charAt(0)];
            int k = 1;
            while (k < words[i].length() && rows[words[i].charAt(k)] == row) {
                k++;
            }
            if (k == words[i].length()) {
                words[j++] = words[i];
            }
        }
        return Arrays.copyOf(words, j);
    }
}

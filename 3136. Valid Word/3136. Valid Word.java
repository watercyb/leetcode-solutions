/*
 * Problem: 3136. Valid Word
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-word/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        int[] masks = new int['z' + 1];
        Arrays.fill(masks, 4);
        for (int i = 'A'; i <= 'Z'; i++) {
            masks[i] = 1;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            masks[i] = 1;
        }
        for (int i = '0'; i <= '9'; i++) {
            masks[i] = 0;
        }
        masks['A'] = 2;
        masks['E'] = 2;
        masks['I'] = 2;
        masks['O'] = 2;
        masks['U'] = 2;
        masks['a'] = 2;
        masks['e'] = 2;
        masks['i'] = 2;
        masks['o'] = 2;
        masks['u'] = 2;
        int n = 0;
        for (char chr : word.toCharArray()) {
            n |= masks[chr];
        }
        return n == 3;
    }
}

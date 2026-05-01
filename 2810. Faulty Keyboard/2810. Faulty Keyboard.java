/*
 * Problem: 2810. Faulty Keyboard
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/faulty-keyboard/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public String finalString(String s) {
        char[] chrs = new char[2 * s.length()];
        int l = s.length() - 1;
        int r = l + 1;
        boolean reversed = false;
        for (char chr : s.toCharArray()) {
            if (chr == 'i') {
                reversed = !reversed;
            } else if (reversed) {
                chrs[l--] = chr;
            } else {
                chrs[r++] = chr;
            }
        }
        StringBuilder SB = new StringBuilder();
        if (reversed) {
            for (int i = r - 1; i > l; i--) {
                SB.append(chrs[i]);
            }
        } else {
            for (int i = l + 1; i < r; i++) {
                SB.append(chrs[i]);
            }
        }
        return SB.toString();
    }
}

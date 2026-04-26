/*
 * Problem: 2381. Shifting Letters II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shifting-letters-ii/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chrs = s.toCharArray();
        int[] changes = new int[chrs.length + 1];
        for (int[] shift : shifts) {
            changes[shift[0]] += shift[2] * 2 - 1;
            changes[shift[1] + 1] -= shift[2] * 2 - 1;
        }
        int changed = 0;
        for (int i = 0; i < chrs.length; i++) {
            changed = (changed + changes[i]) % 26 + 26;
            chrs[i] = (char) ((chrs[i] - 'a' + changed) % 26 + 'a');
        }
        return new String(chrs);
    }
}

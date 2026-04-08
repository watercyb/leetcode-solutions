/*
 * Problem: 709. To Lower Case
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/to-lower-case/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String toLowerCase(String s) {
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] >= 'A' && chrs[i] <= 'Z')
                chrs[i] += 32;
        }
        return new String(chrs);
    }
}

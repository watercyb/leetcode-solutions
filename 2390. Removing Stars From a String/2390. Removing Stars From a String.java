/*
 * Problem: 2390. Removing Stars From a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/removing-stars-from-a-string/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public String removeStars(String s) {
        char[] chrs = new char[s.length()];
        int idx = 0;
        for (char chr : s.toCharArray()) {
            if (chr == '*') {
                idx--;
            } else {
                chrs[idx++] = chr;
            }
        }
        return new String(Arrays.copyOf(chrs, idx));
    }
}

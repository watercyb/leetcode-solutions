/*
 * Problem: 1528. Shuffle String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shuffle-string/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chrs = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chrs[indices[i]] = s.charAt(i);
        }
        return new String(chrs);
    }
}

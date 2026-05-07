/*
 * Problem: 3456. Find Special Substring of Length K
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-special-substring-of-length-k/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        char[] chrs = s.toCharArray();
        int len = 0;
        int prv = '#';
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] != prv) {
                if (len == k)
                    return true;
                len = 1;
                prv = chrs[i];
            } else {
                len++;
            }
        }
        return len == k;
    }
}

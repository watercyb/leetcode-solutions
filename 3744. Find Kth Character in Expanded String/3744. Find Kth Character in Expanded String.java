/*
 * Problem: 3744. Find Kth Character in Expanded String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-kth-character-in-expanded-string/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public char kthCharacter(String s, long k) {
        int count=1;
        for (char chr:s.toCharArray()) {
            if (chr==' ') {
                k--;
                if (k<0) return ' ';
                count=1;
            } else {
                k-=count++;
                if (k<0) return chr;
            }
        }
        return ' ';
    }
}

/*
 * Problem: 387. First Unique Character in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int firstUniqChar(String s) {
        int[] counts = new int['z' + 1];
        char[] chrs=s.toCharArray();
        for (char chr : chrs) {
            counts[chr]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (counts[chrs[i]] == 1)
                return i;
        }
        return -1;
    }
}

/*
 * Problem: 242. Valid Anagram
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-anagram/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        int[] count=new int['z'+1];
        for (char chr:s.toCharArray()) {
            count[chr]++;
        }
        for (char chr:t.toCharArray()) {
            count[chr]--;
            if (count[chr]<0) return false;
        }
        return true;
    }
}

/*
 * Problem: 28. Find the Index of the First Occurrence in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public int strStr(String haystack, String needle) {
        char[] chrH=haystack.toCharArray();
        char[] chrN=needle.toCharArray();
        for (int i = 0; i < chrH.length - chrN.length + 1; i++) {
            int j = 0;
            int k = i;
            while (j < chrN.length && chrN[j]== chrH[k]) {
                j++;
                k++;
            }
            if (j == chrN.length)
                return i;
        }
        return -1;
    }
}

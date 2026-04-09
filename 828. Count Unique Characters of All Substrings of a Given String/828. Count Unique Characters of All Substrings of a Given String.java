/*
 * Problem: 828. Count Unique Characters of All Substrings of a Given String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int uniqueLetterString(String s) {
        int res = 0;
        int[] counts = new int[26];
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        for (int i = 0; i < s.length(); i++) {
            int chr = s.charAt(i) - 'A';
            int tmp = i - idx[chr];
            res += counts[chr] * (tmp);
            counts[chr] = tmp;
            idx[chr] = i;
        }
        int l = s.length();
        for (int i = 0; i <= 25; i++) {
            if (idx[i] != -1)
                res += counts[i] * (l - idx[i]);
        }
        return res;
    }
}

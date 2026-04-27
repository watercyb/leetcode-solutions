/*
 * Problem: 2434. Using a Robot to Print the Lexicographically Smallest String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public String robotWithString(String s) {
        char[] chrs = s.toCharArray();
        int[] counts = new int[26];
        for (char chr : chrs) {
            counts[chr - 'a']++;
        }
        int idx = 0;
        StringBuilder SB = new StringBuilder();
        int l = 0;
        int r = 0;
        while (idx < 26) {
            while (idx < 26 && counts[idx] == 0) {
                idx++;
            }
            if (l > 0 && chrs[l - 1] - 'a' <= idx) {
                SB.append(chrs[l - 1]);
                l--;
            } else {
                chrs[l] = chrs[r];
                counts[chrs[r] - 'a']--;
                l++;
                r++;
            }
        }
        while (l > 0) {
            SB.append(chrs[l - 1]);
            l--;
        }
        return SB.toString();
    }
}

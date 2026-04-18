/*
 * Problem: 1540. Can Convert String in K Moves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/can-convert-string-in-k-moves/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length())
            return false;
        char[] chrS = s.toCharArray();
        char[] chrT = t.toCharArray();
        int[] counts = new int[26];
        int a = k / 26;
        int b = k % 26;
        for (int i = 1; i < 26; i++) {
            counts[i] = a;
            if (i <= b)
                counts[i]++;
        }
        for (int i = 0; i < chrS.length; i++) {
            int diff = (chrT[i] - chrS[i] + 26) % 26;
            counts[diff]--;
        }
        for (int i = 1; i < 26; i++) {
            if (counts[i] < 0)
                return false;
        }
        return true;
    }
}

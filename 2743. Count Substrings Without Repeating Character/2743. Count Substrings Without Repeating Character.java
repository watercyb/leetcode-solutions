/*
 * Problem: 2743. Count Substrings Without Repeating Character
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-substrings-without-repeating-character/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int res = 0;
        int[] idx = new int[26];
        Arrays.fill(idx, -1);
        int last = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int j = s.charAt(i) - 'a';
            if (idx[j] > last)
                last = idx[j];
            idx[j] = i;
            res += i - last;
        }
        return res;
    }
}

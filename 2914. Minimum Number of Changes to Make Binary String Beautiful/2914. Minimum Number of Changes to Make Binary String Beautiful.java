/*
 * Problem: 2914. Minimum Number of Changes to Make Binary String Beautiful
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minChanges(String s) {
        char[] chrs = s.toCharArray();
        int res = 0;
        for (int i = 1; i < chrs.length; i += 2) {
            res += chrs[i] ^ chrs[i - 1];
        }
        return res;
    }
}

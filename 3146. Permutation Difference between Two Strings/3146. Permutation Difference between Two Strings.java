/*
 * Problem: 3146. Permutation Difference between Two Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/permutation-difference-between-two-strings/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] indexes = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            indexes[s.charAt(i)] = i;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Math.abs(i - indexes[t.charAt(i)]);
        }
        return res;
    }
}

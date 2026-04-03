/*
 * Problem: 484. Find Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-permutation/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] findPermutation(String s) {
        char[] chrs = s.toCharArray();
        int min = 1;
        int[] res = new int[chrs.length + 1];
        int i = 0;
        while (i < chrs.length) {
            if (chrs[i] == 'I') {
                res[i++] = min++;
            } else {
                int j = i;
                while (j < chrs.length && chrs[j] == 'D') {
                    j++;
                }
                for (int k = j; k >= i; k--) {
                    res[k] = min++;
                }
                i = j + 1;
            }
        }
        if (i <= chrs.length)
            res[i] = min;
        return res;
    }
}

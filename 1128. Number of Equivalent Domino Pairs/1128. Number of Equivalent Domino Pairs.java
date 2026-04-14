/*
 * Problem: 1128. Number of Equivalent Domino Pairs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] counts = new int[100];
        int res = 0;
        for (int[] domino : dominoes) {
            if (domino[0] > domino[1]) {
                res += counts[domino[1] * 10 + domino[0]]++;
            } else {
                res += counts[domino[0] * 10 + domino[1]]++;
            }
        }
        return res;
    }
}

/*
 * Problem: 3616. Number of Student Replacements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-student-replacements/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int totalReplacements(int[] ranks) {
        int prv = ranks[0];
        int res = 0;
        for (int rank : ranks) {
            if (rank < prv) {
                res++;
                prv = rank;
            }
        }
        return res;
    }
}

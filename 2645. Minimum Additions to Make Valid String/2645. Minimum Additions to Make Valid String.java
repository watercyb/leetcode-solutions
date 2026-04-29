/*
 * Problem: 2645. Minimum Additions to Make Valid String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-additions-to-make-valid-string/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int addMinimum(String word) {
        int turn = 0;
        int res = 0;
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            res += (chr + 3 - turn) % 3;
            turn = (chr + 1) % 3;
        }
        return res + (3 - turn) % 3;
    }
}

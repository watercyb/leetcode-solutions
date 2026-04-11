/*
 * Problem: 1033. Moving Stones Until Consecutive
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/moving-stones-until-consecutive/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        int[] res = new int[2];
        if (c - a > 2) {
            if (b - a <= 2 || c - b <= 2) {
                res[0] = 1;
            } else {
                res[0] = 2;
            }
        }
        res[1] = c - a - 2;
        return res;
    }
}

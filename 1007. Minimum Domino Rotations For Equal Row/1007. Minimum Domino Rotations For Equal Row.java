/*
 * Problem: 1007. Minimum Domino Rotations For Equal Row
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            res = Math.min(Math.min(count(tops, bottoms, i), count(bottoms, tops, i)), res);
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    public int count(int[] tops, int[] bottoms, int i) {
        int res = 0;
        for (int j = 0; j < tops.length; j++) {
            if (tops[j] != i && bottoms[j] != i)
                return Integer.MAX_VALUE;
            if (tops[j] != i)
                res++;
        }
        return Math.min(res, tops.length - res);
    }
}

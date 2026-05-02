/*
 * Problem: 3000. Maximum Area of Longest Diagonal Rectangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxD = 0;
        int maxA = 0;
        for (int[] dimension : dimensions) {
            int d = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            int a = dimension[0] * dimension[1];
            if (d > maxD || (d == maxD && a > maxA)) {
                maxD = d;
                maxA = a;
            }
        }
        return maxA;
    }
}

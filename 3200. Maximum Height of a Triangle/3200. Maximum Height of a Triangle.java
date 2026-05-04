/*
 * Problem: 3200. Maximum Height of a Triangle
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-height-of-a-triangle/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(cal(red, blue, 1), cal(blue, red, 1));
    }

    public int cal(int a, int b, int n) {
        if (a < n)
            return n - 1;
        return cal(b, a - n, n + 1);
    }
}

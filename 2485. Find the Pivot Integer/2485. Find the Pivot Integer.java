/*
 * Problem: 2485. Find the Pivot Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-pivot-integer/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int pivotInteger(int n) {
        int l = (1 + n) * n / 2;
        int res = (int) Math.sqrt(l);
        if (res * res == l)
            return res;
        return -1;
    }
}

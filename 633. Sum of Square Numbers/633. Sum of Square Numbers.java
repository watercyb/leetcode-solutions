/*
 * Problem: 633. Sum of Square Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-square-numbers/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public boolean judgeSquareSum(int c) {
        int l = (int) Math.sqrt(c / 2);
        int r = (int) Math.sqrt(c);
        if (r * r == c)
            return true;
        for (int i = l; i <= r; i++) {
            int j = c - i * i;
            double k = Math.sqrt(j);
            if (k == (int) k)
                return true;
        }
        return false;
    }
}

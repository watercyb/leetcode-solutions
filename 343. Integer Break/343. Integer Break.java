/*
 * Problem: 343. Integer Break
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/integer-break/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int integerBreak(int n) {
        if (n<=2) return 1;
        if (n==3) return 2;
        if (n==4) return 4;
        int pro=1;
        while (n>4) {
            pro*=3;
            n-=3;
        }
        if (n>0) pro*=n;
        return pro;
    }
}

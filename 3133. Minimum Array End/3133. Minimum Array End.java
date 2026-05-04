/*
 * Problem: 3133. Minimum Array End
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-array-end/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public long minEnd(int n, int x) {
        long res = 0;
        long base = 1;
        n--;
        while (n > 0 || x > 0) {
            if ((x & 1) == 0) {
                if ((n & 1) == 1)
                    res += base;
                n /= 2;
            } else {
                res += base;
            }
            x /= 2;
            base *= 2;
        }
        return res;
    }
}

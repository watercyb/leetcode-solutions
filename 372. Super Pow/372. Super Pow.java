/*
 * Problem: 372. Super Pow
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/super-pow/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int superPow(int a, int[] b) {
        int n = 0;
        for (int i = 0; i < b.length; i++)
            n = (n * 10 + b[i]) % 1140;
        if (n == 0)
            n = 1140;
        int res = 1;
        a %= 1337;
        while (n > 0) {
            if ((n & 1) != 0)
                res = (res * a) % 1337;
            a = (a * a) % 1337;
            n >>= 1;
        }
        return res;
    }
}

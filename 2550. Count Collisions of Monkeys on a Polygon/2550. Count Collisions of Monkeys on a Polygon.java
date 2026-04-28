/*
 * Problem: 2550. Count Collisions of Monkeys on a Polygon
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int monkeyMove(int n) {
        return (int) (pow(n) - 2 + mod) % mod;
    }

    int mod = 1_000_000_007;

    public long pow(int n) {
        long res = 1;
        long base = 2;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            n >>= 1;
        }
        return res;
    }
}

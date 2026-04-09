/*
 * Problem: 858. Mirror Reflection
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/mirror-reflection/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int mirrorReflection(int p, int q) {
        int n = p * q / GCD(p, q);
        if (n / q % 2 == 0)
            return 2;
        return n / p % 2;
    }

    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}

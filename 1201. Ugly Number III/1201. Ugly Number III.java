/*
 * Problem: 1201. Ugly Number III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/ugly-number-iii/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1;
        long r = Integer.MAX_VALUE;
        long d = a / GCD(a, b) * b;
        long e = b / GCD(b, c) * c;
        long f = a / GCD(a, c) * c;
        long g = d / GCD(d, c) * c;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (n - mid / a - mid / b - mid / c + mid / d + mid / e + mid / f - mid / g <= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    public long GCD(long a, long b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}

/*
 * Problem: 483. Smallest Good Base
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-good-base/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        for (int i = 63; i > 2; i--) {
            long res = get(num, i);
            if (res > 0)
                return String.valueOf(res);
        }
        return String.valueOf(num - 1);
    }

    public long get(long n, int len) {
        long t = (long) Math.pow(n, 1.0 / (len - 1));
        long l = 2;
        long r = t;
        while (l < r) {
            long mid = (l + r) >>> 1;
            long num = chk(mid, len);
            if (num > n) {
                r = mid;
            } else if (num < n) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        if (chk(l, len) == n)
            return l;
        return -1;
    }

    public long chk(long mid, long len) {
        long res = 0;
        for (int i = 0; i < len; i++) {
            res = res * mid + 1;
        }
        return res;
    }
}

/*
 * Problem: 793. Preimage Size of Factorial Zeroes Function
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int preimageSizeFZF(int k) {
        long l = 0;
        long r = Long.MAX_VALUE;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(k, mid) < 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long res = l;
        l = 0;
        r = Long.MAX_VALUE;
        while (l < r) {
            long mid = (l + r) >>> 1;
            if (chk(k, mid) <= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) (res - l);
    }

    public long chk(long k, long mid) {
        long base = 5;
        while (base <= mid && k >= 0) {
            k -= mid / base;
            base *= 5;
        }
        return k;
    }
}

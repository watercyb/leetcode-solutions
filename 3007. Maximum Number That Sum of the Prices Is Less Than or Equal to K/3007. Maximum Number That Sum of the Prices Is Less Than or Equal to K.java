/*
 * Problem: 3007. Maximum Number That Sum of the Prices Is Less Than or Equal to K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long findMaximumNumber(long k, int x) {
        int lim = (int) (Math.log(k << (x - 1)) / Math.log(2));
        long[] arr = new long[lim + 1];
        long prv = 0;
        for (int i = 0; i <= lim; i++) {
            if ((i + 1) % x == 0) {
                arr[i] = prv + 1;
                prv = 2 * prv + (1l << i);
            } else {
                arr[i] = prv;
                prv = 2 * prv;
            }
        }
        long res = 0;
        int count = 0;
        for (int i = lim; i >= 0; i--) {
            long a = 1l << i;
            if (k >= arr[i] + count * a) {
                k -= arr[i] + count * a;
                res += a;
                if ((i + 1) % x == 0)
                    count++;
            }
        }
        return res;
    }
}

/*
 * Problem: 2438. Range Product Queries of Powers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/range-product-queries-of-powers/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int[] productQueries(int n, int[][] queries) {
        long[] pros = new long[Integer.bitCount(n) + 1];
        long[] revs = new long[pros.length];
        pros[0] = 1;
        revs[0] = 1;
        int idx = 1;
        int base = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                pros[idx] = (pros[idx - 1] * base) % mod;
                revs[idx] = rev(pros[idx]);
                idx++;
            }
            n >>= 1;
            base *= 2;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = (int) (pros[queries[i][1] + 1] * revs[queries[i][0]] % mod);
        }
        return res;
    }

    int mod = 1_000_000_007;

    public long rev(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * rev(mod % a) % mod;
    }
}

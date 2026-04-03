/*
 * Problem: 440. K-th Smallest in Lexicographical Order
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findKthNumber(int n, int k) {
        int res = 1;
        while (k > 1) {
            int count = getCount(n, res);
            if (count >= k) {
                res *= 10;
                k--;
            } else {
                k -= count;
                res++;
            }
        }
        return res;
    }

    public int getCount(int n, long num) {
        int res = 1;
        int base = 10;
        while (n > num) {
            num *= 10;
            if (n - num + 1 >= base) {
                res += base;
            } else {
                res += Math.max(n - num + 1, 0);
            }
            base *= 10;
        }
        return res;
    }
}

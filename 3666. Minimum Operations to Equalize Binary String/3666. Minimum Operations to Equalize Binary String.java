/*
 * Problem: 3666. Minimum Operations to Equalize Binary String
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-equalize-binary-string/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minOperations(String s, int k) {
        int zero = 0;
        for (char chr : s.toCharArray()) {
            zero += '1' - chr;
        }
        if ((s.length() == k && zero > 0 && zero < k) || (zero % 2 != 0 && k % 2 == 0))
            return -1;
        if (zero % k == 0)
            return zero / k;
        int one = s.length() - zero;
        if (zero % 2 == 1) {
            int res = Math.max((zero + k - 1) / k, (2 * one + zero - k - 1) / (one + zero - k));
            res += 1 - res % 2;
            return res;
        } else {
            int res = Math.max((zero + k - 1) / k, (2 * zero + one - k - 1) / (one + zero - k));
            res += res % 2;
            if (k % 2 == 0) {
                int res1 = Math.max((zero + k - 1) / k, (2 * one + zero - k - 1) / (one + zero - k));
                res1 += 1 - res1 % 2;
                res = Math.min(res, res1);
            }
            return res;
        }
    }
}

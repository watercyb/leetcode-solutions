/*
 * Problem: 3154. Find Number of Ways to Reach the K-th Stair
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-number-of-ways-to-reach-the-k-th-stair/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int waysToReachStair(int k) {
        int res = 0;
        if (k <= 1)
            res = 1;
        for (int i = 0; i < 30; i++) {
            k -= 1 << i;
            int diff = 1 - k;
            if (diff >= 0) {
                if (diff <= i + 2) {
                    res += combine(i, diff);
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public int combine(int b, int a) {
        b += 2;
        long res = 1;
        for (int j = 1; j <= a; j++) {
            res *= b--;
            res /= j;
        }
        return (int) res;
    }
}

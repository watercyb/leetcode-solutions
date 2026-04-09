/*
 * Problem: 868. Binary Gap
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-gap/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int binaryGap(int n) {
        int res = 0;
        int dist = Integer.MIN_VALUE;
        while (n > 0) {
            dist++;
            if ((n & 1) == 1) {
                res = Math.max(dist, res);
                dist = 0;
            }
            n >>= 1;
        }
        return res;
    }
}

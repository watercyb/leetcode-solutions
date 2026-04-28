/*
 * Problem: 2571. Minimum Operations to Reduce an Integer to 0
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int minOperations(int n) {
        int count = 0;
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                if (count == 1) {
                    res++;
                    count = 0;
                } else if (count > 1) {
                    res++;
                    count = 1;
                }
            } else {
                count++;
            }
            n /= 2;
        }
        res += Math.min(count, 2);
        return res;
    }
}

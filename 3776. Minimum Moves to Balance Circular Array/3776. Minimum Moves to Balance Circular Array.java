/*
 * Problem: 3776. Minimum Moves to Balance Circular Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-moves-to-balance-circular-array/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        int idx = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (balance[i] < 0)
                idx = i;
            sum += balance[i];
        }
        if (sum < 0)
            return -1;
        int stp = 1;
        int target = -balance[idx];
        long res = 0;
        while (target > 0) {
            int l = (idx + n - stp) % n;
            int r = (idx + stp) % n;
            if (balance[l] + balance[r] >= target) {
                res += (long) stp * target;
                target = 0;
            } else {
                res += (long) stp * (balance[l] + balance[r]);
                target -= balance[l] + balance[r];
            }
            stp++;
        }
        return res;
    }
}

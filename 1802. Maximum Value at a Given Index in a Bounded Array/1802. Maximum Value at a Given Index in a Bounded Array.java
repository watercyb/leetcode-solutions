/*
 * Problem: 1802. Maximum Value at a Given Index in a Bounded Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 0;
        int r = maxSum + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(n, index, maxSum, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int n, int index, int maxSum, int mid) {
        long min = mid;
        if (index + 1 >= mid) {
            min += (long) mid * (mid - 1) / 2 + index - mid + 1;
        } else {
            min += (long) (2 * mid - 1 - index) * index / 2;
        }
        if (n - index >= mid) {
            min += (long) mid * (mid - 1) / 2 + n - index - mid;
        } else {
            min += (long) (2 * mid - n + index) * (n - 1 - index) / 2;
        }
        return min <= maxSum;
    }
}

/*
 * Problem: 3091. Apply Operations to Make Sum of Array Greater Than or Equal to k
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minOperations(int k) {
        if (k == 1)
            return 0;
        k--;
        int n = (int) Math.sqrt(k);
        return Math.min(n + k / n, (n + 1) + k / (n + 1)) - 1;
    }
}

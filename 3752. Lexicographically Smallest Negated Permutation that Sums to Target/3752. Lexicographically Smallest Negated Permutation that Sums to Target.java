/*
 * Problem: 3752. Lexicographically Smallest Negated Permutation that Sums to Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-negated-permutation-that-sums-to-target/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long total = (long) (n + 1) * n / 2;
        if (target > total || target < -total||(total-target)%2==1)
            return new int[0];
        long diff = (total - target)/2;
        int[] res = new int[n];
        boolean[] used = new boolean[n];
        int idx = 0;
        for (int i = n; i >= 1; i--) {
            if (i <= diff) {
                diff -= i;
                used[i - 1] = true;
                res[idx++] = -i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!used[i])
                res[idx++] = i + 1;
        }
        return res;
    }
}

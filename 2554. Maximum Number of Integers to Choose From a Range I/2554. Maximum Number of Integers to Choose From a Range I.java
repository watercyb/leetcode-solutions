/*
 * Problem: 2554. Maximum Number of Integers to Choose From a Range I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] seens = new boolean[10001];
        for (int ban : banned) {
            seens[ban] = true;
        }
        int res = 0;
        for (int i = 1; i <= n && maxSum >= i; i++) {
            if (i >= seens.length || !seens[i]) {
                maxSum -= i;
                res++;
            }
        }
        return res;
    }
}

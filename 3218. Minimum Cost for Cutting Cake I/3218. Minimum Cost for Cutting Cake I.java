/*
 * Problem: 3218. Minimum Cost for Cutting Cake I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-for-cutting-cake-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int res = 0;
        for (int v : verticalCut) {
            res += v;
        }
        for (int h : horizontalCut) {
            res += h;
            for (int v : verticalCut) {
                res += Math.min(h, v);
            }
        }
        return res;
    }
}

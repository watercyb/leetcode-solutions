/*
 * Problem: 1833. Maximum Ice Cream Bars
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-ice-cream-bars/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] counts = new int[100001];
        for (int cost : costs) {
            counts[cost]++;
        }
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                coins -= i;
                if (coins < 0)
                    return res;
                res++;
            }
        }
        return res;
    }
}

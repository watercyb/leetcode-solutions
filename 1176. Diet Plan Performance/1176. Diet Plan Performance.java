/*
 * Problem: 1176. Diet Plan Performance
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/diet-plan-performance/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }
        int res = 0;
        if (sum < lower) {
            res--;
        } else if (sum > upper) {
            res++;
        }
        for (int i = k; i < calories.length; i++) {
            sum += calories[i] - calories[i - k];
            if (sum < lower) {
                res--;
            } else if (sum > upper) {
                res++;
            }
        }
        return res;
    }
}

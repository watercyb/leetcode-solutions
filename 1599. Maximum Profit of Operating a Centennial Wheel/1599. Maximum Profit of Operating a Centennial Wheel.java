/*
 * Problem: 1599. Maximum Profit of Operating a Centennial Wheel
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int res = -2;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < customers.length - 1; i++) {
            if (customers[i] > 4) {
                customers[i + 1] += customers[i] - 4;
                customers[i] = 4;
            }
            sum += customers[i] * boardingCost - runningCost;
            if (sum > max) {
                max = sum;
                res = i;
            }
        }
        int a = customers[customers.length - 1] / 4;
        sum += a * (4 * boardingCost - runningCost);
        if (sum > max) {
            max = sum;
            res = customers.length - 2 + a;
        }
        sum += customers[customers.length - 1] % 4 * boardingCost - runningCost;
        if (sum > max) {
            max = sum;
            res = customers.length - 1 + a;
        }
        return res + 1;
    }
}

/*
 * Problem: 2303. Calculate Amount Paid in Taxes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/calculate-amount-paid-in-taxes/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int prv = 0;
        double res = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i][0]) {
                res += (brackets[i][0] - prv) * brackets[i][1];
            } else {
                res += (income - prv) * brackets[i][1];
                break;
            }
            prv = brackets[i][0];
        }
        return res/100;
    }
}

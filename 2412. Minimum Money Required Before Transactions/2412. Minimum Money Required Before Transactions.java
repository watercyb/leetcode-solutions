/*
 * Problem: 2412. Minimum Money Required Before Transactions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-money-required-before-transactions/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long minimumMoney(int[][] transactions) {
        long max1 = 0;
        long max2 = 0;
        long sum = 0;
        for (int i=0; i < transactions.length; i++) {
            int tmp = transactions[i][1] - transactions[i][0];
            if (tmp < 0) {
                sum += tmp;
                max1 = Math.max(transactions[i][1], max1);
            } else {
                max2 = Math.max(transactions[i][0], max2);
            }
        }
        sum -= Math.max(max1, max2);
        return -sum;
    }
}

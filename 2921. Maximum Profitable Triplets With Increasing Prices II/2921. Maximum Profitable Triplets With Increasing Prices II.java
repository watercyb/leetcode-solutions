/*
 * Problem: 2921. Maximum Profitable Triplets With Increasing Prices II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-profitable-triplets-with-increasing-prices-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int max = 0;
        for (int price : prices) {
            max = Math.max(price, max);
        }
        int[] maxes = new int[prices.length];
        int[] BIT = new int[max + 2];
        Arrays.fill(BIT, Integer.MIN_VALUE / 2);
        for (int i = 0; i < prices.length; i++) {
            maxes[i] = get(BIT, prices[i] - 1);
            insert(BIT, prices[i], profits[i]);
        }
        Arrays.fill(BIT, Integer.MIN_VALUE / 2);
        int res = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            res = Math.max(maxes[i] + profits[i] + get(BIT, max - prices[i] - 1), res);
            insert(BIT, max - prices[i], profits[i]);
        }
        return res;
    }

    public int get(int[] BIT, int i) {
        i++;
        int res = Integer.MIN_VALUE / 2;
        while (i > 0) {
            res = Math.max(BIT[i], res);
            i -= i & -i;
        }
        return res;
    }

    public void insert(int[] BIT, int i, int val) {
        i++;
        while (i < BIT.length) {
            BIT[i] = Math.max(val, BIT[i]);
            i += i & -i;
        }
    }
}

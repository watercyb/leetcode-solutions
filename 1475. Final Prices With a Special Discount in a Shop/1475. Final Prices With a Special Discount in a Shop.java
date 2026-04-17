/*
 * Problem: 1475. Final Prices With a Special Discount in a Shop
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] endPrices = new int[prices.length];
        for (int i = 0; i < prices.length; ++i) {
            endPrices[i] = prices[i];
            for (int j = i + 1; j < prices.length; ++j) {
                if (prices[i] >= prices[j]) {
                    endPrices[i] -= prices[j];
                    break;
                }
            }
        }
        return endPrices;
    }
}

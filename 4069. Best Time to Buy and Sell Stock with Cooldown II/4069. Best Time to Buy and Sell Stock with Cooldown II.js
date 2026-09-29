/*
 * Problem: 4069. Best Time to Buy and Sell Stock with Cooldown II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown-ii/
 * Language: javascript
 * Date: 2026-09-29
 */

/**
 * @param {number[]} prices
 * @param {number} cooldown
 * @param {number[]} costs
 * @return {number}
 */
var maxProfit = function (prices, cooldown, costs) {
    const dp = Array(prices.length).fill(0);
    let max = 0;
    let res = 0;
    for (let i = 0; i < prices.length; i++) {
        max = Math.max(max, dp[i]);
        let profit = 0;
        for (let j = i + 1; j < prices.length; j++) {
            profit = Math.max(profit, prices[j] - prices[i] - costs[j - i]);
            const day = j + cooldown + 1;
            if (day < dp.length && profit + max > dp[day]) dp[day] = profit + max;
        }
        res = Math.max(res, profit + max);
    }
    return res;
};

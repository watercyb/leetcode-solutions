/*
 * Problem: 2706. Buy Two Chocolates
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/buy-two-chocolates/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int buyChoco(int[] prices, int money) {
        int[] min={money,money};
        for (int i=0;i<prices.length;i++) {
            if (prices[i]<min[1]) {
                min[1]=prices[i];
                if (min[1]<min[0]) {
                    int tmp=min[0];
                    min[0]=min[1];
                    min[1]=tmp;
                }
            }
        }
        int re=money-min[0]-min[1];
        if (re<0) return money;
        return re;
        
    }
}

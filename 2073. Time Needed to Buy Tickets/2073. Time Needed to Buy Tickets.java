/*
 * Problem: 2073. Time Needed to Buy Tickets
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/time-needed-to-buy-tickets/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int res=0;
        for (int i=0;i<=k;i++) {
            res+=Math.min(tickets[i],tickets[k]);
        }
        tickets[k]--;
        for (int i=k+1;i<tickets.length;i++) {
            res+=Math.min(tickets[i],tickets[k]);
        }
        return res;
    }
}

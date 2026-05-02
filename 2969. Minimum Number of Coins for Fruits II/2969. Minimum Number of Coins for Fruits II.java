/*
 * Problem: 2969. Minimum Number of Coins for Fruits II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-coins-for-fruits-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minimumCoins(int[] prices) {
        Deque<int[]> Dq = new ArrayDeque<>();
        Dq.offerLast(new int[] { 0, prices.length });
        for (int i = prices.length - 1; i > 0; i--) {
            int[] min = Dq.peekFirst();
            int sum = min[0] + prices[i];
            while (!Dq.isEmpty() && Dq.peekLast()[0] >= sum) {
                Dq.pollLast();
            }
            Dq.offer(new int[] { sum, i });
            while (Dq.peekFirst()[1] > i + i) {
                Dq.pollFirst();
            }
        }
        return Dq.peekFirst()[0] + prices[0];
    }
}

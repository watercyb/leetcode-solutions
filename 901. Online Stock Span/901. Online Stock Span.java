/*
 * Problem: 901. Online Stock Span
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/online-stock-span/
 * Language: java
 * Date: 2026-04-10
 */

class StockSpanner {
    Deque<int[]> Dq = new ArrayDeque<>();

    public int next(int price) {
        int ans = 1;
        while (!Dq.isEmpty() && Dq.peekLast()[0] <= price) {
            ans += Dq.pollLast()[1];
        }
        Dq.offerLast(new int[] { price, ans });
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/*
 * Problem: 2558. Take Gifts From the Richest Pile
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/take-gifts-from-the-richest-pile/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        long res = 0;
        for (int gift : gifts) {
            PQ.offer(gift);
            res += gift;
        }
        for (int i = 0; i < k; i++) {
            int count = PQ.poll();
            int sqrt = (int) Math.sqrt(count);
            res -= count - sqrt;
            PQ.offer(sqrt);
        }
        return res;
    }
}

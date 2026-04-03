/*
 * Problem: 502. IPO
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/ipo/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> PQ1 = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < profits.length; i++) {
            int[] tmp = new int[] { profits[i], capital[i] };
            if (capital[i] <= w) {
                PQ.offer(tmp);
            } else {
                PQ1.offer(tmp);
            }
        }
        for (int i = 0; i < k; i++) {
            while (!PQ1.isEmpty() && PQ1.peek()[1] <= w) {
                PQ.offer(PQ1.poll());
            }
            if (PQ.isEmpty())
                return w;
            w += PQ.poll()[0];
        }
        return w;
    }
}

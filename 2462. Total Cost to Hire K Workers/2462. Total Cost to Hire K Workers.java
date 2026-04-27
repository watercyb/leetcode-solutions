/*
 * Problem: 2462. Total Cost to Hire K Workers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/total-cost-to-hire-k-workers/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        if (k == costs.length) {
            long res = 0;
            for (int cost : costs) {
                res += cost;
            }
            return res;
        } else if (2 * candidates >= costs.length) {
            Arrays.sort(costs);
            long res = 0;
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> last = new PriorityQueue<>();
        int l = 0;
        int r = costs.length - 1;
        int i = 0;
        for (i = 0; i < candidates && l < r; i++) {
            first.offer(costs[l++]);
            last.offer(costs[r--]);
        }
        if (l == r && i < candidates)
            last.offer(costs[r--]);
        long res = 0;
        for (i = 0; i < k; i++) {
            int a = first.isEmpty() ? Integer.MAX_VALUE : first.peek();
            int b = last.isEmpty() ? Integer.MAX_VALUE : last.peek();
            if (a > b) {
                res += last.poll();
                if (r >= l)
                    last.offer(costs[r--]);
            } else {
                res += first.poll();
                if (l <= r)
                    first.offer(costs[l++]);
            }
        }
        return res;
    }
}

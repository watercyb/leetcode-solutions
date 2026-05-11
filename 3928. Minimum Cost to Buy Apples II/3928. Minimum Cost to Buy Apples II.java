/*
 * Problem: 3928. Minimum Cost to Buy Apples II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-buy-apples-ii/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int[] minCost(int n, int[] prices, int[][] roads) {
        int[] counts = new int[n];
        for (int[] road : roads) {
            counts[road[0]]++;
            counts[road[1]]++;
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < n; i++) {
            links[i] = new int[counts[i]][];
        }
        for (int[] road : roads) {
            long cost = (long) road[2] * road[3];
            int c = cost > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) cost;
            links[road[0]][--counts[road[0]]] = new int[] { road[1], road[2], c };
            links[road[1]][--counts[road[1]]] = new int[] { road[0], road[2], c };
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (int) getMin(links, prices, i);
        }
        return res;
    }

    public long getMin(int[][][] links, int[] prices, int i) {
        int[] costs1 = getMin1(links, i, prices[i]);
        int[] costs2 = getMin2(links, i, prices[i]);
        long res = Long.MAX_VALUE;
        for (int j = 0; j < links.length; j++) {
            res = Math.min(res, (long) costs1[j] + costs2[j] + prices[j]);
        }
        return res;
    }

    public int[] getMin1(int[][][] links, int i, int lim) {
        int[] costs = new int[links.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { i, 0 });
        costs[i] = 0;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[0];
            int cost = current[1];
            if (costs[idx] != cost)
                continue;
            for (int[] next : links[idx]) {
                int nextIdx = next[0];
                long nextCost = (long) cost + next[1];
                if (nextCost >= costs[nextIdx] || nextCost >= lim)
                    continue;
                costs[nextIdx] = (int) nextCost;
                PQ.offer(new int[] { nextIdx, (int) nextCost });
            }
        }
        return costs;
    }

    public int[] getMin2(int[][][] links, int i, int lim) {
        int[] costs = new int[links.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { i, 0 });
        costs[i] = 0;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[0];
            int cost = current[1];
            if (costs[idx] != cost)
                continue;
            for (int[] next : links[idx]) {
                int nextIdx = next[0];
                long nextCost = (long) cost + next[2];
                if (nextCost >= costs[nextIdx] || nextCost >= lim)
                    continue;
                costs[nextIdx] = (int) nextCost;
                PQ.offer(new int[] { nextIdx, (int) nextCost });
            }
        }
        return costs;
    }
}

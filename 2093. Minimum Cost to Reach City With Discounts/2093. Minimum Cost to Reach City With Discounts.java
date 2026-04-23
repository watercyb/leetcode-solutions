/*
 * Problem: 2093. Minimum Cost to Reach City With Discounts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-reach-city-with-discounts/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] lists = new ArrayList[n];
        int[] links = new int[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
            links[i] = i;
        }
        for (int[] edge : highways) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
            int a = find(links, edge[0]);
            int b = find(links, edge[1]);
            if (a != b)
                links[a] = b;
        }
        if (find(links, 0) != find(links, n - 1))
            return -1;
        int[][] steps = new int[discounts + 1][n];
        for (int[] row : steps) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PQ.offer(new int[] { 0, 0, 0 });
        steps[0][0] = 0;
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int id = current[1];
            int stp = current[0];
            int dc = current[2];
            if (id == n - 1)
                return stp;
            if (steps[dc][id] != stp)
                continue;
            for (int[] next : lists[id]) {
                int idNext = next[0];
                int stpNext = stp + next[1];
                if (stpNext < steps[dc][idNext]) {
                    steps[dc][idNext] = stpNext;
                    PQ.offer(new int[] { stpNext, idNext, dc });
                }
                stpNext = stp + next[1] / 2;
                if (dc < discounts && stpNext < steps[dc + 1][idNext]) {
                    steps[dc + 1][idNext] = stpNext;
                    PQ.offer(new int[] { stpNext, idNext, dc + 1 });
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= discounts; i++) {
            res = Math.min(steps[i][n - 1], res);
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}

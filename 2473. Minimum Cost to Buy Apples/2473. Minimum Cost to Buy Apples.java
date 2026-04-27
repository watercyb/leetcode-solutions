/*
 * Problem: 2473. Minimum Cost to Buy Apples
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-buy-apples/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : roads) {
            lists[edge[0] - 1].add(new int[] { edge[1] - 1, (k + 1) * edge[2] });
            lists[edge[1] - 1].add(new int[] { edge[0] - 1, (k + 1) * edge[2] });
        }
        int[][][] links = new int[n][][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        long[] res = new long[n];
        Arrays.fill(res, Long.MAX_VALUE);
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            PQ.offer(new Node(appleCost[i], i));
            res[i] = appleCost[i];
        }
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            if (res[current.idx] != current.cost)
                continue;
            for (int[] next : links[current.idx]) {
                long costNext = current.cost + next[1];
                if (costNext < res[next[0]]) {
                    res[next[0]] = costNext;
                    PQ.offer(new Node(costNext, next[0]));
                }
            }
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    long cost;
    int idx;

    public Node(long cost, int idx) {
        this.cost = cost;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node node) {
        if (cost > node.cost) {
            return 1;
        } else if (cost < node.cost) {
            return -1;
        } else {
            return 0;
        }
    }
}

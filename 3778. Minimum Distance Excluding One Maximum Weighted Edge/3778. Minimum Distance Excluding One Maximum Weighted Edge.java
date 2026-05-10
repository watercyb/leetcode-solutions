/*
 * Problem: 3778. Minimum Distance Excluding One Maximum Weighted Edge
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-distance-excluding-one-maximum-weighted-edge/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minCostExcludingMax(int n, int[][] edges) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[] { edge[1], edge[2] });
            lists[edge[1]].add(new int[] { edge[0], edge[2] });
        }
        long[] steps = new long[n];
        long[] steps1 = new long[n];
        Arrays.fill(steps, Long.MAX_VALUE / 2);
        Arrays.fill(steps1, Long.MAX_VALUE / 2);
        steps[0] = 0;
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(0, 0, 0));
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            long stp = current.stp;
            long max = current.max;
            int idx = current.idx;
            if (idx == n - 1)
                return stp;
            if (steps[idx] != stp && steps1[idx] != stp + max)
                continue;
            for (int[] next : lists[idx]) {
                long nextStp = stp + next[1];
                long nextMax = max;
                int nextIdx = next[0];
                if (next[1] > max) {
                    nextMax = next[1];
                    nextStp -= next[1] - max;
                }
                boolean isGood = false;
                if (steps[nextIdx] > nextStp) {
                    steps[nextIdx] = nextStp;
                    isGood = true;
                }
                if (steps1[nextIdx] > nextStp + nextMax) {
                    steps1[nextIdx] = nextStp + nextMax;
                    isGood = true;
                }
                if (isGood)
                    PQ.offer(new Node(nextIdx, nextMax, nextStp));
            }
        }
        return -1;
    }
}

class Node implements Comparable<Node> {
    long stp;
    long max;
    int idx;

    public Node(int idx, long max, long stp) {
        this.idx = idx;
        this.max = max;
        this.stp = stp;
    }

    @Override
    public int compareTo(Node node) {
        return Long.compare(stp, node.stp);
    }
}

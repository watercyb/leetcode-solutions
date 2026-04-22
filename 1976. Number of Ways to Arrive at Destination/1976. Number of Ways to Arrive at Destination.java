/*
 * Problem: 1976. Number of Ways to Arrive at Destination
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<Node>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            lists[road[0]].add(new Node(road[1], road[2]));
            lists[road[1]].add(new Node(road[0], road[2]));
        }
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(0, 0));
        long[] stps = new long[n];
        long[] counts = new long[n];
        Arrays.fill(stps, Long.MAX_VALUE);
        counts[0] = 1;
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            if (current.w > stps[n - 1])
                break;
            if (current.w > stps[current.idx])
                continue;
            for (Node next : lists[current.idx]) {
                long stp = current.w + next.w;
                if (stp > stps[next.idx])
                    continue;
                if (stp < stps[next.idx]) {
                    stps[next.idx] = stp;
                    counts[next.idx] = counts[current.idx];
                } else {
                    counts[next.idx] = (counts[next.idx] + counts[current.idx]) % 1_000_000_007;
                    continue;
                }
                PQ.offer(new Node(next.idx, stp));
            }
        }
        return (int) counts[n - 1];
    }
}

class Node implements Comparable<Node> {
    int idx;
    long w;

    public Node(int idx, long w) {
        this.idx = idx;
        this.w = w;
    }

    public int compareTo(Node node) {
        return Long.compare(w, node.w);
    }
}

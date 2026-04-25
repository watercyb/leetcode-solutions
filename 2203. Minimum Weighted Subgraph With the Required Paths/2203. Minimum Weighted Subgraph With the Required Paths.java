/*
 * Problem: 2203. Minimum Weighted Subgraph With the Required Paths
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-weighted-subgraph-with-the-required-paths/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> lists = new ArrayList<>();
        List<List<int[]>> listsRev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
            listsRev.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            lists.get(edge[0]).add(new int[] { edge[1], edge[2] });
            listsRev.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int[][][] links = new int[n][][];
        int[][][] linksRev = new int[n][][];
        for (int i = 0; i < links.length; i++) {
            List<int[]> list = lists.get(i);
            List<int[]> listRev = listsRev.get(i);
            links[i] = new int[list.size()][];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = list.get(j);
            }
            linksRev[i] = new int[listRev.size()][];
            for (int j = 0; j < linksRev[i].length; j++) {
                linksRev[i][j] = listRev.get(j);
            }
        }
        long[] distFromDest = new long[n];
        Arrays.fill(distFromDest, Long.MAX_VALUE / 3);
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(dest, 0));
        distFromDest[dest] = 0;
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            if (distFromDest[node.idx] != node.stp)
                continue;
            for (int[] next : linksRev[node.idx]) {
                int idx = next[0];
                long stp = node.stp + next[1];
                if (stp < distFromDest[idx]) {
                    distFromDest[idx] = stp;
                    PQ.offer(new Node(idx, stp));
                }
            }
        }
        long[] distFromSrc1 = new long[n];
        Arrays.fill(distFromSrc1, Long.MAX_VALUE / 3);
        PQ.clear();
        PQ.offer(new Node(src1, 0));
        distFromSrc1[src1] = 0;
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            if (distFromSrc1[node.idx] != node.stp)
                continue;
            for (int[] next : links[node.idx]) {
                int idx = next[0];
                long stp = node.stp + next[1];
                if (stp < distFromSrc1[idx]) {
                    distFromSrc1[idx] = stp;
                    PQ.offer(new Node(idx, stp));
                }
            }
        }
        long[] distFromSrc2 = new long[n];
        Arrays.fill(distFromSrc2, Long.MAX_VALUE / 3);
        PQ.clear();
        PQ.offer(new Node(src2, 0));
        distFromSrc2[src2] = 0;
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            if (distFromSrc2[node.idx] != node.stp)
                continue;
            for (int[] next : links[node.idx]) {
                int idx = next[0];
                long stp = node.stp + next[1];
                if (stp < distFromSrc2[idx]) {
                    distFromSrc2[idx] = stp;
                    PQ.offer(new Node(idx, stp));
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, distFromDest[i] + distFromSrc1[i] + distFromSrc2[i]);
        }
        if (res >= Long.MAX_VALUE / 3)
            return -1;
        return res;
    }
}

class Node implements Comparable<Node> {
    int idx;
    long stp;

    public Node(int idx, long stp) {
        this.idx = idx;
        this.stp = stp;
    }

    @Override
    public int compareTo(Node node) {
        return Long.compare(stp, node.stp);
    }
}

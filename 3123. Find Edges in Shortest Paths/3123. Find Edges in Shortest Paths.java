/*
 * Problem: 3123. Find Edges in Shortest Paths
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-edges-in-shortest-paths/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        List<List<int[]>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            links.get(edges[i][0]).add(new int[] { edges[i][1], i });
            links.get(edges[i][1]).add(new int[] { edges[i][0], i });
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        PQ.offer(new int[] { 0, 0, 0, 0 });
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            if (nodes[n - 1] != null && current[2] > nodes[n - 1].val)
                break;
            if (nodes[current[0]] == null) {
                nodes[current[0]] = new Node();
                nodes[current[0]].val = current[2];
                nodes[current[0]].list.add(current[3]);
            } else if (nodes[current[0]].val == current[2]) {
                nodes[current[0]].list.add(current[3]);
            } else {
                continue;
            }
            if (current[0] == n - 1)
                continue;
            for (int[] next : links.get(current[0])) {
                if (next[0] == current[1])
                    continue;
                PQ.offer(new int[] { next[0], current[0], current[2] + edges[next[1]][2], next[1] });
            }
        }
        boolean[] res = new boolean[edges.length];
        dfs(res, new boolean[edges.length], edges, nodes, n - 1);
        return res;
    }

    public void dfs(boolean[] res, boolean[] seens, int[][] edges, Node[] nodes, int n) {
        if (n != 0 && nodes[n] != null) {
            for (int next : nodes[n].list) {
                res[next] = true;
                if (seens[next])
                    continue;
                seens[next] = true;
                if (edges[next][0] == n) {
                    dfs(res, seens, edges, nodes, edges[next][1]);
                } else {
                    dfs(res, seens, edges, nodes, edges[next][0]);
                }
            }
        }
    }
}

class Node {
    int val;
    List<Integer> list = new ArrayList<>();
}

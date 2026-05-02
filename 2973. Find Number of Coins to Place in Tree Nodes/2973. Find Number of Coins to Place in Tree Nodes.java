/*
 * Problem: 2973. Find Number of Coins to Place in Tree Nodes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-number-of-coins-to-place-in-tree-nodes/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long[] placedCoins(int[][] edges, int[] cost) {
        List<Integer>[] lists = new ArrayList[edges.length + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }
        int[][] links = new int[lists.length][];
        for (int i = 0; i < links.length; i++) {
            links[i] = new int[lists[i].size()];
            for (int j = 0; j < links[i].length; j++) {
                links[i][j] = lists[i].get(j);
            }
        }
        res = new long[links.length];
        dfs(links, cost, 0, -1);
        return res;
    }

    long[] res;

    public Node dfs(int[][] links, int[] cost, int i, int prv) {
        Node node = new Node(cost[i]);
        for (int next : links[i]) {
            if (next == prv)
                continue;
            node = node.combine(dfs(links, cost, next, i));
        }
        res[i] = node.getMax();
        return node;
    }

}

class Node {
    int[] p = new int[4];
    int[] n = new int[4];
    int idxP = 0;
    int idxN = 0;

    public Node(int num) {
        if (num == 0)
            return;
        if (num > 0) {
            p[idxP++] = num;
        } else {
            n[idxN++] = num;
        }
    }

    public Node combine(Node node) {
        Node res = new Node(0);
        int i = 0;
        int j = 0;
        while (res.idxP < 3 && (i < idxP || j < node.idxP)) {
            if (j == node.idxP || (i < idxP && p[i] >= node.p[j])) {
                res.p[res.idxP++] = p[i];
                i++;
            } else {
                res.p[res.idxP++] = node.p[j];
                j++;
            }
        }
        i = 0;
        j = 0;
        while (res.idxN < 3 && (i < idxN || j < node.idxN)) {
            if (j == node.idxN || (i < idxN && n[i] <= node.n[j])) {
                res.n[res.idxN++] = n[i];
                i++;
            } else {
                res.n[res.idxN++] = node.n[j];
                j++;
            }
        }
        return res;
    }

    public long getMax() {
        if (idxN + idxP < 3)
            return 1;
        if (idxP == 0)
            return 0;
        if (idxP == 1)
            return (long) n[0] * n[1] * p[0];
        if (idxP == 2) {
            if (idxN == 1)
                return 0;
            if (idxN >= 2)
                return (long) n[0] * n[1] * p[0];
        }
        if (idxN <= 1)
            return (long) p[0] * p[1] * p[2];
        return Math.max((long) p[0] * p[1] * p[2], (long) n[0] * n[1] * p[0]);
    }
}

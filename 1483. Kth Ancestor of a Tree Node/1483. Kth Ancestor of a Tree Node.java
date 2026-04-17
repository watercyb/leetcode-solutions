/*
 * Problem: 1483. Kth Ancestor of a Tree Node
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 * Language: java
 * Date: 2026-04-17
 */

class TreeAncestor {
    int[] parent;
    int[][] dist;

    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        int l=(int) (Math.log(n) / Math.log(2)) + 1;
        dist = new int[n][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dist[j][i] = parent[j];
                } else if (dist[j][i - 1] != -1) {
                    dist[j][i] = dist[dist[j][i - 1]][i - 1];
                } else {
                    dist[j][i] = -1;
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int j=0;
        while (k > 0) {
            if (k%2==1) {
                node = dist[node][j];
                if (node==-1) break;
            }
            k/=2;
            j++;
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

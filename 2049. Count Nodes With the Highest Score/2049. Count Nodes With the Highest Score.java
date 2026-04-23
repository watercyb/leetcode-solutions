/*
 * Problem: 2049. Count Nodes With the Highest Score
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-nodes-with-the-highest-score/
 * Language: java
 * Date: 2026-04-23
 */

import com.sun.source.tree.Tree;

class Solution {
    public int countHighestScoreNodes(int[] parents) {
        TreeNode[] nodes = new TreeNode[parents.length];
        for (int i = 0; i < parents.length; i++) {
            nodes[i] = new TreeNode(i);
        }
        TreeNode head = new TreeNode();
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                head = nodes[i];
            } else if (nodes[parents[i]].left != null) {
                nodes[parents[i]].right = nodes[i];
            } else {
                nodes[parents[i]].left = nodes[i];
            }
        }
        dfs(head, parents.length);
        return res;
    }

    int res = 0;
    long max = 0;

    public int dfs(TreeNode node, int n) {
        if (node == null)
            return 0;
        int l = dfs(node.left, n);
        int r = dfs(node.right, n);
        int total = l + r + 1;
        int remain = n - total;
        long pro = 1;
        if (l != 0)
            pro *= l;
        if (r != 0)
            pro *= r;
        if (remain != 0)
            pro *= remain;
        if (pro > max) {
            max = pro;
            res = 1;
        } else if (pro == max) {
            res++;
        }
        return total;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }
}

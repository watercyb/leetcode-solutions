/*
 * Problem: 919. Complete Binary Tree Inserter
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/complete-binary-tree-inserter/
 * Language: java
 * Date: 2026-04-10
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class CBTInserter {
    TreeNode[] nodes = new TreeNode[5000];
    int idx = -1;

    public CBTInserter(TreeNode root) {
        dfs(root, 0);
        idx++;
    }

    public void dfs(TreeNode node, int n) {
        if (node == null)
            return;
        nodes[n] = node;
        if (n > idx)
            idx = n;
        dfs(node.left, 2 * n + 1);
        dfs(node.right, 2 * n + 2);
    }

    public int insert(int val) {
        nodes[idx] = new TreeNode(val);
        if ((idx & 1) == 1) {
            int p = idx / 2;
            nodes[p].left = nodes[idx++];
            return nodes[p].val;
        } else {
            int p = idx / 2 - 1;
            nodes[p].right = nodes[idx++];
            return nodes[p].val;
        }
    }

    public TreeNode get_root() {
        return nodes[0];
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */

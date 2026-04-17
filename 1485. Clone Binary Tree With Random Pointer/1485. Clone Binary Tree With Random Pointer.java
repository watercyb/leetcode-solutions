/*
 * Problem: 1485. Clone Binary Tree With Random Pointer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
 * Language: java
 * Date: 2026-04-17
 */

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        NodeCopy res = dfs(root);
        dfs(res, root);
        return res;
    }

    HashMap<Node, NodeCopy> HM = new HashMap<>();

    public NodeCopy dfs(Node node) {
        if (node == null)
            return null;
        NodeCopy res = new NodeCopy(node.val);
        res.left = dfs(node.left);
        res.right = dfs(node.right);
        HM.put(node, res);
        return res;
    }

    public void dfs(NodeCopy a, Node b) {
        if (a == null)
            return;
        if (b.random != null)
            a.random = HM.get(b.random);
        dfs(a.left, b.left);
        dfs(a.right, b.right);
    }
}

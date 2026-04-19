/*
 * Problem: 1666. Change the Root of a Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/change-the-root-of-a-binary-tree/
 * Language: java
 * Date: 2026-04-19
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node flipBinaryTree(Node root, Node leaf) {
        leaf.left = leaf.parent;
        leaf.parent = null;
        dfs(root, leaf.left, leaf);
        return leaf;
    }

    public void dfs(Node root, Node node, Node par) {
        if (node != root) {
            if (node.left == par) {
                node.left = null;
            } else {
                node.right = node.left;
            }
            node.left = node.parent;
            node.parent = par;
            dfs(root, node.left, node);
        } else {
            if (node.left == par) {
                node.left = null;
            } else {
                node.right = null;
            }
            node.parent = par;
        }
    }
}
